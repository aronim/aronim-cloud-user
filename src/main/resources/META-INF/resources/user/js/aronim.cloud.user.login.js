(function () {
    "use strict";

    define(["jquery",
            "angular",
            "common/js/aronim.cloud.common",
            "text!user/template/aronim.cloud.user.login.html"],

        function ($, angular, aronim, aronimCloudLoginTemplate) {

            angular
                .module("aronim.cloud.user.login", [])
                .factory("acUserLoginService", acUserLoginService)
                .directive("acUserLoginForm", acUserLoginForm);

            function acUserLoginService($q, $http, $window) {
                return {
                    login: function (command) {

                        var deferred = $q.defer();

                        var headers = {
                            authorization: "Basic " + $window.btoa(command.emailAddress + ":" + command.password)
                        };

                        $http.get("/login", {headers: headers})
                            .success(function (data) {
                                deferred.resolve(data);
                            }).error(function (data) {
                            deferred.reject(data.message);
                        });

                        return deferred.promise;
                    }
                };
            }

            function acUserLoginFormController ($scope, $window, acUserLoginService) {

                $scope.command = {};

                $scope.login = function () {
                    acUserLoginService
                        .login($scope.command)
                        .then(function () {
                            $window.location.href = "/";
                        }, function (errorMessage) {
                            $scope.errorMessage = errorMessage;
                        });
                };
            }

            function acUserLoginForm () {
                return {
                    scope: {},
                    restrict: "E",
                    template: aronimCloudLoginTemplate,
                    controller: acUserLoginFormController
                };
            }
        }
    );
}());