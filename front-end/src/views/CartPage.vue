<template>
  <div>
    <Navbar />
    <div class="container">
        <div class="table" >
          <div class="layout-inline row th">
            <div class="col col-pro">Product Name</div>
            <div class="col col-qty align-center">Quantity</div>
            <div class="col">Category</div>
            <div class="col col-price align-center">Price</div>
            <div class="col col-price align-center">Total Price</div>
          </div>
          
          <div class="layout-inline row" v-for="product in productsList" :key="product.ProductName">
            <div class="col col-pro layout-inline">
                <p>{{product.ProductName}}</p>
            </div>
            <div class="col col-qty layout-inline">
                <p>{{product.NumberOfItems}}</p>
            </div>
            <div class="col col-total col-numeric">
                <p>{{product.Category}}</p>
            </div>
            <div class="col col-price col-numeric align-center ">
                <p>{{product.ProductPrice}}$</p>
            </div>
            <div class="col col-price col-numeric align-center ">
                <p>{{product.ProductTotalPrice}}$</p>
            </div>
          </div>
    </div>
    <div>
      <form style="margin-bottom:20px">
        <label>Promo code: (Optional)</label><br>
        <input type="text" id="text-box" name="text-box" value="" style="border-radius:20px; padding:5px"><br>
      </form> 
      <button class="button button1">Check Out</button>
    </div>
    </div>
    
  </div>
</template>

<script>
  import Navbar from "../components/nbar.vue";
  export default {
    name: "CartPage",
    isAdmin: true ,
    components: {
      Navbar,
    },
    data() {
      return {
        productsList: [
          {ProductName:'Mobile', NumberOfItems:'2', ProductPrice:'340', ProductTotalPrice:'680', Category:'Electronics'},
        ],
      };
    },
    methods: {

    },
  };
</script>

<style scoped>

.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {
  background-color: #4CAF50;
}

html {
  background: #bbc3c6;
  font: 62.5%/1.5em "Trebuchet Ms", helvetica;
}


h1 {
  text-transform: uppercase;
  font-weight: bold;
  font-size: 2.5em;
}

p {
  font-size: 1.5em;
  color: #8a8a8a;
}

img {
  max-width: 9em;
  width: 100%;
  overflow: hidden; 
  margin-right: 1em;
}

a {
  text-decoration: none;
}

.container {
  max-width: 75em;
  width: 95%;
  margin: 80px auto;  
  overflow: hidden;
  position: relative;
  border-radius: 0.6em;
  background: #ecf0f1;
  box-shadow: 0 0.5em 0 rgba(138, 148, 152, 0.2);
}


.cart {
  margin: 2.5em;
  overflow: hidden;
}

.table {
  background: #ffffff;
  border-radius: 0.6em;
  overflow: hidden;
  clear: both;
  margin-bottom: 1.8em;
}


.layout-inline > * {
  display: inline-block;
}

.align-center {
  text-align: center;
}

.th {
  background: #f34d35;
  color: #fff;
  text-transform: uppercase;
  font-weight: bold;
  font-size: 1.5em;
}

.tf {
  background: #f34d35;
  text-transform: uppercase;
  text-align: right;
  font-size: 1.2em;  
}

.tf p {
  color: #fff;
  font-weight: bold;
}

.col {
  padding: 1em;
  width: 12%;
}

.col-pro {
  width: 44%;
}

.col-pro > * {
  vertical-align: middle;
}

.col-qty {
  text-align: center;
  width: 17%;
}

.col-numeric p {
  font: bold 1.8em helvetica;
}

.col-total p {
  color: #12c8b1;
}

.tf .col {
  width: 20%;
}

.row > div {
  vertical-align: middle;
}

.col-qty > * {
  vertical-align: middle; 
}


a.qty {
  width: 1em;
  line-height: 1em;
  border-radius: 2em;
  font-size: 2.5em;
  font-weight: bold;
  text-align: center;
  background: #43ace3;  
  color: #fff;
}

a.qty:hover {
  background: #3b9ac6;
}

.btn {
  padding: 10px 30px;
  border-radius: 0.3em;
  font-size: 1.4em;
  font-weight: bold;
  background: #43ace3;
  color: #fff;
  box-shadow: 0 3px 0 rgba(59,154,198, 1)
}

.btn:hover {
  box-shadow: 0 3px 0 rgba(59,154,198, 0)
}

.btn-update {
  float: right;
  margin: 0 0 1.5em 0;
}

.transition {
  transition: all 0.3s ease-in-out;
}

@media screen and ( max-width: 755px) {
  .container {
    width: 98%;
  }
  
  .col-pro {
    width: 35%;
  }
  
  .col-qty {
    width: 22%;
  }
  
  img {
    max-width: 100%;
    margin-bottom: 1em;
  }
}

@media screen and ( max-width: 580px) {
  
}
</style>
