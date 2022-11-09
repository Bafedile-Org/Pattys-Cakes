<html>
  <head class="top-head">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Pacifico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
        html, body {
          background-color: #f4f4f4;
        }
        .sf {
          min-height: 400px;
        }
      </style>
    </head>
<body class='chec'>
    <nav class="home-head">
            <div class="topnav">
                <h1 align="center" id="home-header1"> Check out
                    <i class="fa fa-bars dropdown" aria-hidden="true" style="font-size:24px; padding-right: 24px">
                        <div class="dropdown-content">
                        <a href="management_page.jsp">Back</a>
                        </div>
                    </i>
                </h1>
            </div>
        </nav>
    <div class="mainscreen">
      <div class="card">
        <div class="leftside">
            <form action="#">
                <h2>Person's Information</h2>
                <p>Customer name: </p>
                <p>Surname: </p>
                <p>Delivery Address: </p>
                <p>Cellphone number: </p>
            </form>
        </div>

            <div class="rightside">
          <form action="#">
              <div class="input-field" style="text-align: center">
            <h2>Payment Information</h2>
           
            <p>Cardholder Name</p>
            <input type="text" class="inputbox" name="name" required />
            <p>Card Number</p>
            <input type="number" class="inputbox" name="card_number" id="card_number" required />
           
            <p>Card Type </p>
            <select class="inputbox" name="card_type" id="card_type" required>
              <option value="">--Select a Card Type--</option>
              <option value="Visa">Visa</option>
              <option value="RuPay">Credit</option>
              <option value="MasterCard">MasterCard</option>
            </select></p>
    <div class="expcvv">

            <p class="expcvv_text">Expiry</p>
            <input type="date" class="inputbox" name="exp_date" id="exp_date" required />

            <p class="expcvv_text2">CVV</p>
            <input type="password" class="inputbox" name="cvv" id="cvv" required />
        </div>
            
       
            <button type="submit" class="button">CheckOut</button>
            </div>
          </form>
        </div>
      </div>
    </div>
</body>
  
