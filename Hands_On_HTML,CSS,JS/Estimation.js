
/* 

    Fill with appropriate and required javascript global variables  code here 

*/


function EstimateReducingInterestLoan()
{
	/* Fill with required javascript code to read input values from HTML Components  */

        var p;
        var r;
        var n;
        
        p = parseInt(document.getElementById("principalAmount").value);
        r = parseInt(document.getElementById("interestRate").value);
        n = parseInt(document.getElementById("tenure").value);
        /*
        console.log(p);
        console.log(r);
        console.log(n);
        
        console.log(typeof p);
        console.log(typeof r);
        console.log(typeof n);
        */
        
        var ti;
        var tp;
        var emi;
        
        /*
        console.log(ti);
        console.log(tp);
        console.log(emi);
        
        console.log(typeof ti);
        console.log(typeof tp);
        console.log(typeof emi);
        */
    
	  calculateEMI();
      totalPayment();
      totalInterest();
      EstimateFixedInterestLoan();


    
}

function EstimateFixedInterestLoan()
{
    /* Fill with required javascript code here  */
    var p;
    var r;
    var n;
    
    p = parseInt(document.getElementById("principalAmount").value);
    r = parseInt(document.getElementById("interestRate").value);
    n = parseInt(document.getElementById("tenure").value);
    
    
    var ti;
    var tp;
    var emi;
    var year = n/12;
    ti = p*r/100*year;
    
    document.getElementById("tInterestFixed").innerHTML = ti.toFixed(2); /*Assign total Interest value here*/
    
     /* Fill with required javascript code here  */
    tp = p+ti;
    document.getElementById("tPaymentFixed").innerHTML = tp.toFixed(2); /*Assign total payment value here*/
    
     /* Fill with required javascript code here  */
    emi = tp/(year*12)
    document.getElementById("EMIFixed").innerHTML = emi.toFixed(2); /*Assign emi  value here*/
    
    
}

function calculateEMI(){
	
    /* Fill with required javascript code here  */
    
    p = parseInt(document.getElementById("principalAmount").value);
    r = parseInt(document.getElementById("interestRate").value);
    n = parseInt(document.getElementById("tenure").value);
      
    var R = r/100/12;
    var a = R+1;
    var eqn = Math.pow(a,n);
    emi = p*R*eqn/(eqn-1);
    
    document.getElementById("EMI").innerHTML = emi.toFixed(2);/*Assign emi value here*/
}

function totalPayment(){
	
	
	/* Fill with required javascript code here  */
	
	var p;
    var r;
    var n;

    p = parseInt(document.getElementById("principalAmount").value);
    r = parseInt(document.getElementById("interestRate").value);
    n = parseInt(document.getElementById("tenure").value);

    var ti;
    var tp;
    var emi;

	var R = r/100/12;
    var a = R+1;
    var eqn = Math.pow(a,n);
    emi = p*R*eqn/(eqn-1);
	tp = emi*n;
    document.getElementById("tPayment").innerHTML = tp.toFixed(2); /*Assign total payment value here*/
}

function totalInterest(){
	
/* Fill with required javascript code here  */

    var p;
    var r;
    var n;
    
    p = parseInt(document.getElementById("principalAmount").value);
    r = parseInt(document.getElementById("interestRate").value);
    n = parseInt(document.getElementById("tenure").value);


    var ti;
    var tp;
    var emi;


    var R = r/100/12;
    var a = R+1;
    var eqn = Math.pow(a,n);
    emi = p*R*eqn/(eqn-1);
	var tp = emi*n;
	var ti = tp-p;
    document.getElementById("tInterest").innerHTML = ti.toFixed(2); /*Assign total Interest value here*/
}


