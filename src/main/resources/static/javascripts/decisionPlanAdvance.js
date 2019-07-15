/**
 * 
 */

 $(document).ready(function(){
    document.getElementById("startButton").setAttribute("onclick", "startButtonListener()");
    getNextQuestion();
 });


 function startButtonListener(){
    document.getElementById("intro").style.display="none";
    document.getElementById("question1").style.display="block";
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
    var questionNumber = questionId.replace("question","");
    var questionPanel = document.getElementById(questionId);
    questionPanel.style.display = "none";
    if($("input[name='"+questionId+"']:checked").val() == "")
    {
        loadNextQuestion(questionNumber);
    }
    else
    {
       var nextStep = $("input[name='"+questionId+"']:checked").val() ;
       var answer = document.getElementById("nextStepAnswer");
       answer.getElementsByTagName("p")[0].innerHTML = nextStep;
       answer.style.display="block"

    }
}

function loadNextQuestion(questionNumber)
{
    var nextQuestion = document.getElementById("question"+ (parseInt(questionNumber)+1));
    nextQuestion.style.display = "block";
}

