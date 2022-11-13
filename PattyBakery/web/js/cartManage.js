
function increment1() {
    document.getElementById('amountInput1').stepUp();
    multiply1();
}
function decrement1() {
    document.getElementById('amountInput1').stepDown();
    multiply1();
}


function increment2() {
    document.getElementById('amountInput2').stepUp();
    multiply2();
}
function decrement2() {
    document.getElementById('amountInput2').stepDown();
    multiply2();
}


function increment3() {
    document.getElementById('amountInput3').stepUp();
    multiply3();
}
function decrement3() {
    document.getElementById('amountInput3').stepDown();
    multiply3();
}


function remove1() {
    document.getElementById('div1').style.display = 'none';

}
function remove2() {
    document.getElementById('div2').style.display = 'none';

}

function remove3() {
    document.getElementById('div3').style.display = 'none';

}

function multiply1() {

    a = Number(document.getElementById('amountInput1').value);
    b = Number(document.getElementById('price1').name);
    c = a * b;
    document.getElementById('price1').value = c.toFixed(2);
    totalAmount();

}
function multiply2() {

    a = Number(document.getElementById('amountInput2').value);
    b = Number(document.getElementById('price2').name);
    c = a * b;
    document.getElementById('price2').value = c.toFixed(2);
    totalAmount();

}

function multiply3() {

    a = Number(document.getElementById('amountInput3').value);
    b = Number(document.getElementById('price3').name);
    c = a * b;
    document.getElementById('price3').value = c.toFixed(2);
    totalAmount();

}

function removeAll() {
    document.getElementsByClassName('item').style.display = 'none';

}

function totalAmount() {
    a = Number(document.getElementById('price1').value);
    b = Number(document.getElementById('price2').value);
    c = Number(document.getElementById('price3').value);
    total = a + b + c;
    document.getElementById('totalAmount').value = total.toFixed(2);
    total += 100;
    document.getElementById('totalAmountDue').value = total.toFixed(2);
}
