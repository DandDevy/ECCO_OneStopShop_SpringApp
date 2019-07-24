/**
 * 
 */
 $(document).ready(function(){
    document.getElementById("startButton").setAttribute("onclick", "startButtonListener()");
    getNextQuestion();
 });

 /**
  * Listener for the start button in the advance tech decision plan.
  * It will show the first question that is hidden
  */
 function startButtonListener(){
    document.getElementById("intro").style.display="none";
    document.getElementById("intro").nextElementSibling.style.display="block";
}

/**
 * This is a function that add dynamically all the listener to the next question button
 */
function getNextQuestion(){
    
    var questionButtons = document.getElementsByClassName("questionButton");
    for(var i=0; i< questionButtons.length; i++)
    {
        questionButtons[i].setAttribute( "onclick", "listener("+questionButtons[i].id+")");
    }
}

/**
 * 
 * @param {HTMLObjectElement} theButton, the next question button
 * This is a generic listener that will check the answer of the user, if he choose "Yes"  the next question will 
 * be load. If the user choose "No", the next question will be show next
 */
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

/**
 * 
 * @param {String} questionId, the next question id
 * A function that will show the next question
 */
function loadNextQuestion(questionId)
{
    var currentQuestion = document.getElementById(questionId);
    currentQuestion.nextElementSibling.style.display = "block";
}

