(function(){
var app = angular.module("test", ['game','ngRoute']);

app.controller('TestController', function(){
  this.tab = 1;

  this.selectTab = function(setTab){
    this.tab = setTab;
  };

  this.isSelected = function(checkTab){
    return this.tab === checkTab;
  };
});

 app.controller('FighterController', function(){
   this.fighters = players;
 });

 app.controller('EntryController',  function(){
   this.entry = {};

   this.addFighter = function(){
    console.log(this.entry);
    players.push(this.entry);
    this.entry = {};
   }
 });

  var players = [
  {
    name: "Default Joe",
    style: 1
  },
  
  {
    name: "Forgotten Freddy",
    style: 2
  }
 ];

 app.directive('tryInclude', function(){
  return{
    retrict: 'E',
    templateUrl: 'views/include-test.html'
  };
 });

})();
