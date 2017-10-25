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
    var app = angular.module("app", []);
    app.controller("angController", function ($scope, $http, $filter) {
        $scope.start = 0;
        $scope.limit = "15";

        $scope.loadMainData = function () {
            function getMainData(res) {
                $scope.list = res.data.list;
            }

            ajaxCall($http, "cases/get-cases?start=" + $scope.start + "&limit=" + $scope.limit, null, getMainData);
        }

        $scope.loadMainData();

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
                function rsFnc(res) {
                    $scope.slctedCaseInstances = res.data;
                }

                ajaxCall($http, "cases/get-instance-history?id=" + id, null, rsFnc);
            }
        };

        $scope.edit = function (id) {
            if (id != undefined) {
                var selected = $filter('filter')($scope.list, {caseId: id}, true);
                $scope.request = selected[0];
            }
        };

        $scope.init = function () {
            $scope.request = null;
        };

        $scope.save = function () {
            function resFunc(res) {
                if (res.errorCode == 0) {
                    successMsg('ოპერაცია დასრულდა წარმატებით');
                    $scope.loadMainData();
                    closeModal('editModal');
                }
            }

            ajaxCall($http, "cases/save-case", angular.toJson({
                id: $scope.request.caseId,
                name: $scope.request.name
            }), resFunc);
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
                            <th class="text-right">დამთავრების შედეგი</th>
                            <td>{{slcted.endResultName}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">თანამშრომელი</th>
                            <td>{{slcted.addUser}}</td>
                        </tr>
                        <tr>
                            <th class="text-right">სტატუსი</th>
                            <td>{{slcted.statusName}}</td>
                        </tr>

                        <tr ng-show="slctedCaseInstances.length > 0">
                            <th class="text-right">კატეგორია(ები):</th>
                            <td>
                                <ul>
                                    <li ng-repeat="v in slctedCaseInstances">{{v.id}}</li>
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
                            <label class="control-label col-sm-3">საქმის დამთავრების შედეგი</label>
                            <div class="col-sm-9">
                                <textarea rows="5" cols="10" ng-model="request.name"
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
                    <button type="button" class="btn btn-block btn-primary btn-md" ng-click="init()" data-toggle="modal"
                            data-target="#editModal">
                        <i class="fa fa-plus" aria-hidden="true"></i> &nbsp;
                        დამატება
                    </button>
                </div>
                <div class="col-md-2 col-xs-offset-8">
                    <select ng-change="loadMainData()" class="pull-right form-control" ng-model="limit"
                            id="rowCountSelectId">
                        <option value="15" selected>მაჩვენე 15</option>
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
                    <tbody>
                    <tr ng-repeat="r in list">
                        <td>{{r.caseId}}</td>
                        <td>{{r.name}}</td>
                        <td>{{r.number}}</td>
                        <td>{{r.courtName}}</td>
                        <td>{{r.judgeName}}</td>
                        <td>{{r.caseStartDate}}</td>
                        <td>{{r.caseEndDate}}</td>
                        <td>{{r.addUser}}</td>
                        <td>{{r.statusName}}</td>
                        <td class="text-center">
                            <a ng-click="showDetails(r.caseId)" data-toggle="modal" title="დეტალურად"
                               data-target="#detailModal" class="btn btn-lg">
                                <i class="fa fa-sticky-note-o"></i>&nbsp; დეტალურად
                            </a>&nbsp;&nbsp;
                            <a ng-click="edit(r.caseId)" data-toggle="modal" data-target="#editModal"
                               class="btn btn-xs">
                                <i class="fa fa-pencil"></i>&nbsp;შეცვლა
                            </a>&nbsp;&nbsp;
                            <a ng-click="remove(r.caseId)" class="btn btn-xs">
                                <i class="fa fa-trash-o"></i>&nbsp;წაშლა
                            </a>
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