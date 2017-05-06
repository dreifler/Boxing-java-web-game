//Greeting by time of day
var today = new Date();
var hourNow = today.getHours();
var greeting;

if (hourNow > 18) {
    greeting = 'Good Evening!';
    } else if (hourNow > 12) {
        greeting = 'Good Afternoon!';
    } else if (hourNow > 0){
        greeting = 'Good Morning!';
    } else {
        greeting = 'Welcome!';
    }

document.write ('<h2>' + greeting + '</h2>');

//Replacing data from the page with javascript text
var title;
var message;

title="<h1>Simulated Boxing</h1>";
message="<p>A boxing simulation game currently under development.</p>";

var elTitle = document.getElementById('title');
elTitle.innerHTML = title;
var elNote = document.getElementById('note');
elNote.innerHTML = message;
