/**
 * 
 */

 $(document).ready(function(){
    document.getElementById("startButton").setAttribute("onclick", "startButtonListener()");
    getNextQuestion();
 });


 function startButtonListener(){
    document.getElementById("intro").style.display="none";
    document.getElementById("intro").nextElementSibling.style.display="block";
}

function getNextQuestion(){
    
    var questionButtons = document.getElementsByClassName("questionButton");
    for(var i=0; i< questionButtons.length; i++)
    {
        questionButtons[i].setAttribute( "onclick", "listener("+questionButtons[i].id+")");
    }
}
function listener(theButton){
    var questionId = theButton.parentElement.parentElement.id;
    var questionPanel = document.getElementById(questionId);
    questionPanel.style.display = "none";
    if($("input[name='"+questionId+"']:checked").val() == "" ||$("input[name='"+questionId+"']:checked").val() == "null"  )
    {
        loadNextQuestion(questionId);
    }
    else
    {
       var nextStep = $("input[name='"+questionId+"']:checked").val() ;
       var answer = document.getElementById("nextStepAnswer");
       answer.getElementsByTagName("p")[0].innerHTML = nextStep;
       answer.style.display="block"

    }
}

function loadNextQuestion(questionId)
{
    var currentQuestion = document.getElementById(questionId);
    currentQuestion.nextElementSibling.style.display = "block";
}

