(function () {
    "use strict";

    define(["jquery",
            "angular",
            "common/js/aronim.cloud.common",
            "text!user/template/aronim.cloud.user.registration.html",
            "user/js/aronim.cloud.user.login"],

        function ($, angular, aronimCloud, aronimCloudUserRegistationFormTemplate) {

            var module = angular.module("aronim.cloud.user.registration", ["aronim.cloud.user.login"]);

            module.factory("aronimCloudUserRegistrationService",
                function ($q, $http) {

                    return {
                        userWithEmailAddressExists: function (emailAddress) {

                            var deferred = $q.defer();

                            $http
                                .get("/api/users/exists", {params: {emailAddress: emailAddress}})
                                .success(function (data, status, headers, config) {
                                    deferred.resolve(data);
                                })
                                .error(function (data, status, headers, config) {
                                    deferred.reject(data.message);
                                });

                            return deferred.promise;
                        },
                        register: function (command) {

                            var deferred = $q.defer();

                            $http
                                .put("/api/users/register", command)
                                .success(function (data, status, headers, config) {
                                    deferred.resolve();
                                })
                                .error(function (data, status, headers, config) {
                                    deferred.reject(data.message);
                                });

                            return deferred.promise;
                        }
                    };
                }
            );

            module.directive("aronimCloudUserRegistrationForm",
                function ($window, $log, aronimCloudUserRegistrationService, aronimCloudUserLoginService) {
                    return {
                        scope: {},
                        restrict: "E",
                        template: aronimCloudUserRegistationFormTemplate,
                        controller: function ($scope) {

                            $scope.command = {
                                id: aronim.cloud.common.guid()
                            };

                            $scope.$watch("command.emailAddress", function(emailAddress) {

                                if (angular.isUndefined(emailAddress)) {
                                    $scope.errorMessage = undefined;
                                    return;
                                }

                                aronimCloudUserRegistrationService
                                    .userWithEmailAddressExists(emailAddress)
                                    .then(function(userWithEmailAddressExists) {

                                        if (userWithEmailAddressExists) {
                                            $scope.errorMessage = "User with email address already exists";
                                        } else {
                                            $scope.errorMessage = undefined;
                                        }
                                    });
                            });

                            $scope.register = function () {

                                aronimCloudUserRegistrationService
                                    .register($scope.command)
                                    .then(function () {

                                        aronimCloudUserLoginService
                                            .login($scope.command)
                                            .then(function () {
                                                $window.location.href = "/";
                                            }, function (errorMessage) {
                                                $scope.errorMessage = errorMessage;
                                            });

                                    }, function (errorMessage) {
                                        $scope.errorMessage = errorMessage;
                                    });
                            };
                        }
                    };
                }
            );
        }
    );
}());