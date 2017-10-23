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
        $scope.users = [];

        function getUsers(res) {
            console.log(res.data);
            $scope.users = res.data;
        }

        ajaxCall($http, "users/get-users", null, getUsers);


        $scope.remove = function (id) {
            if (confirm("დარწმუნებული ხართ რომ გსურთ წაშლა?")) {
                if (id != undefined) {
                    ajaxCall($http, "users/delete-user?userId=" + id, null, reload);
                }
            }
        };

        $scope.edit = function (id) {
            if (id != undefined) {
                var selected = $filter('filter')($scope.users, {userId: id}, true);
                $scope.request = selected[0];
            }
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
                            <label class="control-label col-sm-3">ნიკი</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" ng-model="request.password"
                                       class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">პაროლი</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" ng-model="request.password"
                                       class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10 ">
                            <label class="control-label col-sm-3">სახელი</label>
                            <div class="col-sm-9">
                                <input type="text" ng-model="request.firstname" class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10">
                            <label class="control-label col-sm-3">გვარი</label>
                            <div class="col-xs-9">
                                <input type="text" ng-model="request.lastname" class="form-control input-sm">
                            </div>
                        </div>
                        <div class="form-group col-sm-10">
                            <label class="control-label col-sm-3">სტატუსი</label>
                            <div class="col-xs-9 btn-group">
                                <div class="radio col-xs-3">
                                    <label><input type="radio" ng-model="request.statusId" value="1"
                                                  class="input-sm"> ატიური</label>
                                </div>
                                <div class="radio col-xs-3">
                                    <label><input type="radio" ng-model="request.statusId" value="2"
                                                  class=" input-sm"> პასიური</label>
                                </div>
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
                    <button type="button" class="btn btn-block btn-primary btn-md">
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
                        <th>გვარი</th>
                        <th>ნიკი</th>
                        <th>ტიპი</th>
                        <th>სტატუსი</th>
                        <th class="col-md-1 text-center">დამატ. დრო</th>
                        <th class="col-md-2 text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="r in users">
                        <td>{{r.userId}}</td>
                        <td>{{r.firstname}}</td>
                        <td>{{r.lastname}}</td>
                        <td>{{r.username}}</td>
                        <td>{{r.typeId == 2 ? 'ოპერატორი': 'ადმინისტრატორი'}}</td>
                        <td>{{r.statusId == 1 ? 'აქტიური': 'პასიური'}}</td>
                        <td class="text-center">
                            <small>{{r.insertDate}}</small>
                        </td>
                        <td class="text-center">
                            <a ng-click="edit(r.userId)" data-toggle="modal" data-target="#editModal"
                               class="btn btn-xs">
                                <i class="fa fa-pencil"></i>&nbsp;შეცვლა
                            </a>&nbsp;|&nbsp;
                            <a ng-click="remove(r.userId)" class="btn btn-xs">
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