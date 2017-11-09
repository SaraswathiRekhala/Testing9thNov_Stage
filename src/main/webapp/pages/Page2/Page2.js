Application.$controller("Page2PageController", ["$scope", function ($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function () {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };

}]);


Application.$controller("executeSV_ChannelsDataTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("executeSV_CustomersDataTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("executeSV_FollowUpsDataTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("executeSV_LeadsDataTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("executeSV_ProductsDataTable1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);