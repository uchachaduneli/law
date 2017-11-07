<%--
  Created by IntelliJ IDEA.
  User: ME
  Date: 10/23/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<style>
    #chartdiv {
        width: 100%;
        height: 350px;
        font-size: 11px;
    }
</style>

<!-- Resources -->
<script src="resources/js/amcharts.js"></script>
<script src="resources/js/serial.js"></script>
<script src="resources/js/light.js"></script>

<script>
    app.controller("angController", function ($scope, $http, $filter) {
        $scope.srchCase = {};
    });


    var chart = AmCharts.makeChart("chartdiv", {
        "type": "serial",
        "theme": "light",
        "dataProvider": [{
            "country": "USA",
            "visits": 2025
        }, {
            "country": "China",
            "visits": 1882
        }, {
            "country": "Japan",
            "visits": 1809
        }, {
            "country": "Germany",
            "visits": 1322
        }],
        "valueAxes": [{
            "gridColor": "#FFFFFF",
            "gridAlpha": 0.2,
            "dashLength": 0
        }],
        "gridAboveGraphs": true,
        "startDuration": 1,
        "graphs": [{
            "balloonText": "[[category]]: <b>[[value]]</b>",
            "fillAlphas": 0.8,
            "lineAlpha": 0.2,
            "type": "column",
            "valueField": "visits"
        }],
        "chartCursor": {
            "categoryBalloonEnabled": false,
            "cursorAlpha": 0,
            "zoomable": false
        },
        "categoryField": "country",
        "categoryAxis": {
            "gridPosition": "start",
            "gridAlpha": 0,
            "tickPosition": "start",
            "tickLength": 20
        }

    });
</script>

<div class="col-md-12">
    <div id="filter-panel" class="filter-panel">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="form-group col-md-1">
                    <input type="text" class="form-control srch" ng-model="srchCase.caseId"
                           placeholder="ID">
                </div>
                <div class="form-group col-md-2">
                    <input type="text" class="form-control srch" ng-model="srchCase.name"
                           placeholder="დასახელება">
                </div>
                <div class="form-group col-md-2">
                    <input type="text" class="form-control srch" ng-model="srchCase.number"
                           placeholder="საქმის #">
                </div>
                <div class="form-group col-md-2">
                    <input type="text" class="form-control srch"
                           ng-model="srchCase.judgeAssistant" placeholder="თანაშემწე">
                </div>
                <div class="form-group col-md-2">
                    <input type="text" class="form-control srch"
                           ng-model="srchCase.judgeAssistantPhone" placeholder="თანაშემწის ტელ.">
                </div>
                <div class="form-group col-md-3">
                    <div class="input-group">
                        <div class="input-append">
                            <input type="text" name="startdate" class="form-control srch"
                                   placeholder="დან"
                                   ng-model="srchCase.caseStartDateFrom" placeholder="">
                        </div>
                        <span class="input-group-addon">დაწყებ. თარიღ.</span>
                        <div class="input-append">
                            <input type="text" name="startdate" class="form-control srch"
                                   placeholder="მდე"
                                   ng-model="srchCase.caseStartDateTo" placeholder="">
                        </div>
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <div class="input-group">
                        <div class="input-append">
                            <input type="text" name="enddate" class="form-control srch"
                                   placeholder="დან"
                                   ng-model="srchCase.caseEndDateFrom" placeholder="">
                        </div>
                        <span class="input-group-addon">დასრ. თარიღ.</span>
                        <div class="input-append">
                            <input type="text" name="enddate" class="form-control srch"
                                   placeholder="მდე"
                                   ng-model="srchCase.caseEndDateTo" placeholder="">
                        </div>
                    </div>
                </div>
                <div class="form-group col-md-3">
                    <select class="form-control" ng-model="srchCase.judgeId" ng-change="loadMainData()">
                        <option value="" selected="selected">მოსამართლე</option>
                        <option ng-repeat="v in judges" ng-selected="v.judgeId === srchCase.judgeId"
                                value="{{v.judgeId}}">{{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <select class="form-control" ng-model="srchCase.litigationSubjectId"
                            ng-change="loadMainData()">
                        <option value="" selected="selected">დავის საგანი</option>
                        <option ng-repeat="v in litigationsubjects"
                                ng-selected="v.litigationSubjectId === srchCase.litigationSubjectId"
                                value="{{v.litigationSubjectId}}">
                            {{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <select class="form-control" ng-model="srchCase.courtInstanceId"
                            ng-change="loadMainData()">
                        <option value="" selected="selected">სასამართლო ინსტანცია</option>
                        <option ng-repeat="v in courtInstances"
                                ng-selected="v.instanceId === srchCase.courtInstanceId"
                                value="{{v.instanceId}}">{{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <select class="form-control" ng-model="srchCase.endResultId"
                            ng-change="loadMainData()">
                        <option value="" selected="selected">დამთავრების შედეგი</option>
                        <option ng-repeat="v in endresults"
                                ng-selected="srchCase.endResultId === v.endResultId"
                                value="{{v.endResultId}}">{{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-3">
                    <select class="form-control" ng-model="srchCase.courtId" ng-change="loadMainData()">
                        <option value="" selected="selected">სასამართლო</option>
                        <option ng-repeat="v in courts"
                                ng-selected="v.courtId === srchCase.courtId"
                                value="{{v.courtId}}">{{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <select class="form-control" ng-model="srchCase.statusId"
                            ng-change="loadMainData()">
                        <option value="" selected="selected">სტატუსი</option>
                        <option ng-repeat="v in statuses"
                                ng-selected="v.statusId === srchCase.statusId"
                                value="{{v.statusId}}">{{v.name}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <select class="form-control" ng-model="srchCase.addUserId"
                            ng-change="loadMainData()">
                        <option value="" selected="selected">მომხმარებელი</option>
                        <option ng-repeat="v in users"
                                ng-selected="v.userId === srchCase.addUserId"
                                value="{{v.userId}}">{{v.firstname}}{{v.lastname}}
                        </option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <button class="btn btn-default col-md-11" ng-click="loadMainData()" id="srchBtnId">
                        <span class="fa fa-search"></span> &nbsp; &nbsp;ძებნა &nbsp; &nbsp;
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.box-header -->
<div class="box-body">

    <div class="col col-xs-6">
        <div class="small-box bg-aqua">
            <div class="inner">
                <h3>150</h3>

                <p>New Orders</p>
            </div>
            <div class="icon">
                <i class="ion ion-stats-bars"></i>
            </div>
        </div>
    </div>
    <div class="col col-xs-6">
        <div class="small-box bg-aqua-active">
            <div class="inner">
                <h3>150</h3>

                <p>New Orders</p>
            </div>
            <div class="icon">
                <i class="ion ion-pie-graph"></i>
            </div>
        </div>
    </div>
</div>
<div id="chartdiv"></div>

<%@include file="footer.jsp" %>