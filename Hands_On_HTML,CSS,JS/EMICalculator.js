
/* 

    Fill with appropriate javascript code here 
    

*/

function calculateEMI(){
    var p = parseInt(document.getElementById("principalAmount").value);
    var r = parseInt(document.getElementById("interestRate").value);
    var n = parseInt(document.getElementById("tenure").value);
    var R = r/100/12;
    var a = R+1;
    var eqn = Math.pow(a,n);
    var EMI = p*R*eqn/(eqn-1);
    var msg = "EMI is Rs."+EMI.toFixed(2);
    /*
    console.log(p);
    console.log(r);
    console.log(R);
    console.log(n);
    console.log(a);
    console.log(eqn);
    console.log(EMI);
    console.log(msg);
    */
    
    
    document.getElementById("result").innerHTML = msg;
    //alert("");
    return false;
    
    
    
    
    
}