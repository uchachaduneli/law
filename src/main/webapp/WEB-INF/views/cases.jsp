<%--
  Created by IntelliJ IDEA.
  User: ME
  Date: 10/23/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<script>

    $(document).ready(function () {

        $('input[name="startdate"]').datepicker({
            format: "dd/mm/yyyy",
            autoclose: true,
            language: 'ka'
        }).on('changeDate', function (ev) {
//            $("#caseStartDateInput").val($("#caseStartDateInput").val());
        });

        $('input[name="enddate"]').datepicker({
            format: "dd/mm/yyyy",
            autoclose: true,
            language: 'ka'
        }).on('changeDate', function (ev) {
//            $("#monthSeterInputId").val($("#srch_datepicker").val());
        });

    });

    app.controller("angController", function ($scope, $http, $filter) {
        $scope.start = 0;
        $scope.limit = "10";
        $scope.request = {};
        $scope.srchCase = {};

        $scope.loadMainData = function () {
            function getMainData(res) {
                $scope.list = res.data.list;
            }

            ajaxCall($http, "cases/get-cases?start=" + $scope.start + "&limit=" + $scope.limit, angular.toJson($scope.srchCase), getMainData);
        }

        $scope.loadMainData();

        function getlitigationsubjects(res) {
            $scope.litigationsubjects = res.data;
        }

        ajaxCall($http, "litigationsubjects/get-litigationsubjects", null, getlitigationsubjects);

        function getjudges(res) {
            $scope.judges = res.data;
        }

        ajaxCall($http, "judges/get-judges", null, getjudges);

        function getcourtInstances(res) {
            $scope.courtInstances = res.data;
        }

        ajaxCall($http, "courtInstances/get-courtinstances", null, getcourtInstances);

        function getendresults(res) {
            $scope.endresults = res.data;
        }

        ajaxCall($http, "endresults/get-endresults", null, getendresults);

        function getcourts(res) {
            $scope.courts = res.data;
        }

        ajaxCall($http, "courts/get-courts", null, getcourts);

        function getstatuses(res) {
            $scope.statuses = res.data;
        }

        ajaxCall($http, "cases/get-status", null, getstatuses);

        $scope.remove = function (id) {
            if (confirm("დარწმუნებული ხართ რომ გსურთ წაშლა?")) {
                if (id != undefined) {
                    function resFnc(res) {
                        if (res.errorCode == 0) {
                            successMsg('ოპერაცია დასრულდა წარმატებით');
                            $scope.loadMainData();
                        }
                    }

                    ajaxCall($http, "cases/delete-case?id=" + id, null, resFnc);
                }
            }
        };

        $scope.showDetails = function (id) {
            if (id != undefined) {
                var selected = $filter('filter')($scope.list, {caseId: id}, true);
                $scope.slcted = selected[0];

                function rsFnc(res) {
                    console.log(res.data);
                    $scope.slctedCaseInstances = res.data;
                }

                ajaxCall($http, "cases/get-instance-history?id=" + id, null, rsFnc);
            }
        };

        $scope.handleDoubleClick = function (id) {
            $scope.showDetails(id);
            $('#detailModal').modal('show');
        };

        $scope.edit = function (id) {
            if (id != undefined) {
                var selected = $filter('filter')($scope.list, {caseId: id}, true);
                $scope.request = selected[0];
                console.log($scope.request);
//                $scope.request.judgeId = parseInt($scope.request.judgeId);
            }
        };

        $scope.init = function () {
            $scope.request = {};
        };

        $scope.save = function () {
            function resFunc(res) {
                if (res.errorCode == 0) {
                    successMsg('ოპერაცია დასრულდა წარმატებით');
                    $scope.loadMainData();
                    closeModal('editModal');
                } else {
                    errorMsg('ოპერაცია არ სრულდება! გადაამოწმეთ ველების მართებულობა');
                }
            }

            if ($scope.request.caseStartDate != undefined && $scope.request.caseStartDate.includes('/')) {
                $scope.request.caseStartDate = $scope.request.caseStartDate.split(/\//).reverse().join('-')
            }
            if ($scope.request.caseEndDate != undefined && $scope.request.caseEndDate.includes('/')) {
                $scope.request.caseEndDate = $scope.request.caseEndDate.split(/\//).reverse().join('-')
            }
            ajaxCall($http, "cases/save-case", angular.toJson($scope.request), resFunc);
        };

        $scope.handlePage = function (h) {
            if (parseInt(h) >= 0) {
                $scope.start += $scope.limit;
            } else {
                $scope.start += $scope.limit;
            }
            $scope.loadMainData();
        }

    });
</script>

<div class="modal fade bs-example-modal-lg" id="detailModal" tabindex="-1" role="dialog"
     aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="detailModalLabel">დეტალური ინფორმაცია</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <table class="table table-striped">
                        <tr>
                            <th class="col-md-4 text-right">ID</th>
                            <td>{{slcted.caseId}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">დასახელება</th>
                            <td>{{slcted.name}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">საიდენტიფიკაციო N</th>
                            <td>{{slcted.number}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">სასამართლო</th>
                            <td>{{slcted.courtName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">მოსამართლე</th>
                            <td>{{slcted.judgeName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">თანაშემწე</th>
                            <td>{{slcted.judgeAssistant}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">თანაშემწის ტელეფონი</th>
                            <td>{{slcted.judgeAssistantPhone}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">საქმის დაწყების დრო</th>
                            <td>{{slcted.caseStartDate}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">საქმის დამთავრების დრო</th>
                            <td>{{slcted.caseEndDate}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">დავის საგანი</th>
                            <td>{{slcted.litigationSubjectName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">დავის შინაარსი</th>
                            <td>{{slcted.litigationDescription}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">დამთავრების შედეგი</th>
                            <td>{{slcted.endResultName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">თანამშრომელი</th>
                            <td>{{slcted.addUserName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">სტატუსი</th>
                            <td>{{slcted.statusName}}</td>
                        </tr>

                        <tr ng-show="slctedCaseInstances.length > 0">
                            <th class="text-right">სასამართლო ინსტანცია(ები):</th>
                            <td>
                                <ul>
                                    <li ng-repeat="v in slctedCaseInstances">{{v.courtInstanceName}} -- {{v.insertDate}}<br/>
                                        <small>{{v.note}}</small>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                    <div class="form-group"><br/></div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
        </div>
    </div>
</div>

<div class="modal fade bs-example-modal-lg" id="editModal" role="dialog" aria-labelledby="editModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="editModalLabel">შეიტანეთ ინფორმაცია</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form class="form-horizontal" name="myForm">
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">დასახელება</label>
                            <div class="col-sm-9">
                                <input type="text" ng-model="request.name"
                                       class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">საქმის #</label>
                            <div class="col-sm-9">
                                <input type="text" ng-model="request.number"
                                       class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">მოსამართლე</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.judgeId">
                                    <option ng-repeat="v in judges" ng-selected="v.judgeId === request.judgeId"
                                            value="{{v.judgeId}}">{{v.name}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">საქმის დაწყების თარიღი</label>
                            <div class="col-sm-9">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" name="startdate" ng-model="request.caseStartDate"
                                           id="caseStartDateInput"
                                           class="form-control pull-right">
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">საქმის დასრულების თარიღი</label>
                            <div class="col-sm-9">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" name="enddate" ng-model="request.caseEndDate"
                                           id="caseEndDateInput"
                                           class="form-control pull-right">
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">დავის საგანი</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.litigationSubjectId">
                                    <option ng-repeat="v in litigationsubjects"
                                            ng-selected="v.litigationSubjectId === request.litigationSubjectId"
                                            value="{{v.litigationSubjectId}}">
                                        {{v.name}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">დავის შინაარსი</label>
                            <div class="col-sm-9">
                                <textarea rows="5" cols="10" ng-model="request.litigationDescription"
                                          class="form-control input-sm"></textarea>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">სასამართლო ინსტანცია</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.courtInstanceId">
                                    <option ng-repeat="v in courtInstances"
                                            ng-selected="v.instanceId === request.courtInstanceId"
                                            value="{{v.instanceId}}">{{v.name}}
                                    </option>
                                </select>
                            </div>
                            <div class="col-sm-9">
                                <textarea rows="5" cols="10" placeholder="შენიშვნა" ng-model="request.courtInstanceNote"
                                          class="form-control input-sm"></textarea>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">საქმის დამთავრების შედეგი</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.endResultId">
                                    <option ng-repeat="v in endresults"
                                            ng-selected="request.endResultId === v.endResultId"
                                            value="{{v.endResultId}}">{{v.name}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">სასამართლო</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.courtId">
                                    <option ng-repeat="v in courts" ng-selected="v.courtId === request.courtId"
                                            value="{{v.courtId}}">{{v.name}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">სტატუსი</label>
                            <div class="col-sm-9">
                                <select class="form-control" ng-model="request.statusId">
                                    <option ng-repeat="v in statuses" ng-selected="v.statusId === request.statusId"
                                            value="{{v.statusId}}">{{v.name}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">შენიშვნა</label>
                            <div class="col-sm-9">
                                <textarea rows="5" cols="10" ng-model="request.note"
                                          class="form-control input-sm"></textarea>
                            </div>
                        </div>
                        <div class="form-group col-sm-10"></div>
                        <div class="form-group col-sm-10"></div>
                        <div class="form-group col-sm-12 text-center">
                            <a class="btn btn-app" ng-click="save()">
                                <i class="fa fa-save"></i> შენახვა
                            </a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <div class="col-md-2">
                    <c:if test="<%= isAdmin %>">
                        <button type="button" class="btn btn-block btn-primary btn-md" ng-click="init()"
                                data-toggle="modal"
                                data-target="#editModal">
                            <i class="fa fa-plus" aria-hidden="true"></i> &nbsp;
                            დამატება
                        </button>
                    </c:if>
                </div>
                <div class="col-md-2 col-xs-offset-8">
                    <select ng-change="loadMainData()" class="pull-right form-control" ng-model="limit"
                            id="rowCountSelectId">
                        <option value="10" selected>მაჩვენე 10</option>
                        <option value="15">15</option>
                        <option value="30">30</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                    </select>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>დასახელება</th>
                        <th>საქმის #</th>
                        <th>სასამართლო</th>
                        <th>მოსამართლე</th>
                        <th>საქმე დაიწყო</th>
                        <th>საქმე დასრულდა</th>
                        <th>თანამშრომელი</th>
                        <th>სტატუსი</th>
                        <th class="col-md-2 text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody title="დეტალური ინფორმაციისთვის დაკლიკეთ ორჯერ">
                    <tr ng-repeat="r in list" ng-dblclick="handleDoubleClick(r.caseId)">
                        <td>{{r.caseId}}</td>
                        <td>{{r.name}}</td>
                        <td>{{r.number}}</td>
                        <td>{{r.courtName}}</td>
                        <td>{{r.judgeName}}</td>
                        <td>{{r.caseStartDate}}</td>
                        <td>{{r.caseEndDate}}</td>
                        <td>{{r.addUserName}}</td>
                        <td>{{r.statusName}}</td>
                        <td class="text-center">
                            <a ng-click="showDetails(r.caseId)" data-toggle="modal" title="დეტალურად"
                               data-target="#detailModal" class="btn btn-xs">
                                <i class="fa fa-sticky-note-o"></i>&nbsp; დეტალურად
                            </a>&nbsp;&nbsp;
                            <c:if test="<%= isAdmin %>">
                                <a ng-click="edit(r.caseId)" data-toggle="modal" data-target="#editModal"
                                   class="btn btn-xs">
                                    <i class="fa fa-pencil"></i>&nbsp;შეცვლა
                                </a>&nbsp;&nbsp;
                                <a ng-click="remove(r.caseId)" class="btn btn-xs">
                                    <i class="fa fa-trash-o"></i>&nbsp;წაშლა
                                </a>
                            </c:if>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div class="panel-footer">
                    <div class="row">
                        <div class="col col-xs-8 col-xs-offset-4">
                            <ul class="pagination pull-right">
                                <li>
                                    <a ng-click="handlePage(-1)">«</a>
                                </li>
                                <li>
                                    <a ng-click="handlePage(1)">»</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>