(function () {
    "use strict";

    define(["jquery",
            "angular",
            "common/js/aronim.cloud.common",
            "text!user/template/aronim.cloud.user.login.html"],

        function ($, angular, aronim, aronimCloudLoginTemplate) {

            angular
                .module("aronim.cloud.user.login", [])
                .factory("aronimCloudUserLoginService", aronimCloudUserLoginService)
                .directive("aronimCloudUserLoginForm", aronimCloudUserLoginForm);

            function aronimCloudUserLoginService($q, $http, $window) {
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

            function aronimCloudUserLoginFormController ($scope, $window, aronimCloudUserLoginService) {

                $scope.command = {};

                $scope.login = function () {

                    aronimCloudUserLoginService
                        .login($scope.command)
                        .then(function () {
                            $window.location.href = "/";
                        }, function (errorMessage) {
                            $scope.errorMessage = errorMessage;
                        });
                };
            }

            function aronimCloudUserLoginForm () {
                return {
                    scope: {},
                    restrict: "E",
                    template: aronimCloudLoginTemplate,
                    controller: aronimCloudUserLoginFormController
                };
            }
        }
    );
}());