(function(){
var app = angular.module('game', []);

app.directive('gameInfo', function(){
  return{
    retrict: 'E',
    templateUrl: 'views/info.html'
  };
 });

 app.directive('gamePanels', function(){
  return{
    restrict: 'E',
    templateUrl: 'views/game-panels.html',
    controller: function(){

    },
    controllerAs: 'panels'
  };
 });
})();