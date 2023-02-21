feedbacks = []
function addFeedback(){
 //Fill the required logic
 var feedBack = document.getElementById('feedback').value;
 feedbacks.push(feedBack);
 var result = document.getElementById('result');
    result.innerHTML = "<h2>Feedback Details</h2><p>Successfully Added Feedback Details!</p>";
    
    
}

function displayFeedback(){
    //Fill the required logic
     var result = document.getElementById('result');
    var resultText = "<h2>Feedback Details</h2>";
    for(var i = 0;i<feedbacks.length;i++){
        resultText = resultText + "Feedback "+(parseInt(i+1))+"<br>";
        resultText = resultText + feedbacks[i] + "<br>";
    }
    
    result.innerHTML = resultText;
    feedbacks = [];
    
    
}