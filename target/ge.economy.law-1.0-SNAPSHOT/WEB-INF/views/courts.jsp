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

        $scope.loadMainData = function () {
            function getMainData(res) {
                $scope.list = res.data;
            }

            ajaxCall($http, "courts/get-courts", null, getMainData);
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

                    ajaxCall($http, "courts/delete-court?id=" + id, null, resFnc);
                }
            }
        };

        $scope.edit = function (id) {
            if (id != undefined) {
                var selected = $filter('filter')($scope.list, {courtId: id}, true);
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

            ajaxCall($http, "courts/save-court", angular.toJson({
                id: $scope.request.courtId,
                name: $scope.request.name
            }), resFunc);
        };

    });
</script>


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
                            <label class="control-label col-sm-3">სასამართლოს დასახელება</label>
                            <div class="col-sm-9">
                                <input type="text" ng-model="request.name"
                                       class="form-control input-sm">
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
    <div class="col-xs-10 col-xs-offset-1">
        <div class="box">
            <div class="box-header">
                <div class="col-md-2">
                    <button type="button" class="btn btn-block btn-primary btn-md" ng-click="init()" data-toggle="modal"
                            data-target="#editModal">
                        <i class="fa fa-plus" aria-hidden="true"></i> &nbsp;
                        დამატება
                    </button>
                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>სახელი</th>
                        <th class="col-md-2 text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="r in list">
                        <td>{{r.courtId}}</td>
                        <td>{{r.name}}</td>
                        <td class="text-center">
                            <a ng-click="edit(r.courtId)" data-toggle="modal" data-target="#editModal"
                               class="btn btn-xs">
                                <i class="fa fa-pencil"></i>&nbsp;შეცვლა
                            </a>&nbsp;|&nbsp;
                            <a ng-click="remove(r.courtId)" class="btn btn-xs">
                                <i class="fa fa-trash-o"></i>&nbsp;წაშლა
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>