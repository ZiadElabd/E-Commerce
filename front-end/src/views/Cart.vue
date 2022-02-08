<template>
  <div>
    <Navbar />
      <div class="shopping-cart">
        <div id="app">

  <!-- Product List -->
  <section class="container">
    <div v-if="products.length > 0">
      <ul class="products">
      <li class="row" v-for="(product, index) in products" :key="index">
        <div class="col left">
          <div class="thumbnail">
            <a href="#">
              <img :src="product.image" :alt="product.name" />
            </a>
          </div>
          <div class="detail">
            <div class="name"><a href="#">{{ product.name }}</a></div>
            <div class="description">{{ product.description }}</div>
            <div class="price">{{ product.price  }}</div>
          </div>
        </div>

        <div class="col right">
          <div class="quantity">
            <input type="number" class="quantity" step="1" :value="product.quantity"  @blur="checkQuantity(index, $event)" />
          </div>
          
          <div class="remove">
            <span  variant="danger" @click="deleteFromCart(product)">  <b-button>remove</b-button></span>
          </div>
        </div>
      </li>
    </ul>
    </div>
    <div v-else class="empty-product">
      <h3>There are no products in your cart.</h3>
      <button>Shopping now</button>
    </div>
  </section>
  <!-- End Product List -->
  
  <!-- Summary -->
  <section class="container" v-if="products.length > 0">

    <div class="summary">
      <ul>
        <li>Subtotal <span>{{ subTotal | currencyFormatted }}</span></li>
        <li v-if="discount > 0">Discount <span>{{ discountPrice | currencyFormatted }}</span></li>
        <li>Tax <span>{{ tax | currencyFormatted }}</span></li>
        <li class="total">Total <span>{{ totalPrice | currencyFormatted }}</span></li>
      </ul>
    </div>

    <div class="checkout">
      <button type="button">Check Out</button>
    </div>
  </section>
  <!-- End Summary -->
</div>
      </div>
    </div>
</template>
<script>
import Navbar from "../components/nbar.vue";

export default {
  components:{
        Navbar
    },
  data() {
    
    return{
        products: [],
    tax: 5,
    }
  },
  mounted: {},
  computed: {
    isAdmin() {
      return this.$store.state.role;
    },
    product() {
      return this.$route.params.product;
    },
    userID() {
      return this.$store.state.userID;
    },
  },
  methods: {
    checkQuantity: function(i,e){
      console.log("bluuuuuur" + i + e) ;
    },
    parseJSON: function (resp) {
      return resp.json();
    },
    checkStatus: function (resp) {
      console.log("status");
      console.log(resp);
      if (resp.status >= 200 && resp.status < 300) {
        console.log("good status");
        return resp;
      }
      console.log("bad status");
      return this.parseJSON(resp).then((resp) => {
        throw resp;
      });
    },
    deleteCart() {
      try {
        fetch(
          "http://localhost:8080/user/deleteCart/" + this.userID,
          {
            method: "delete",
          }
        );
      } catch (error) {
        alert("error");
      }
      this.products = [];
    },
    deleteFromCart(product) {
      try {
        fetch(
          "http://localhost:8080/user/deleteFromCart/" +
            this.userID +
            "/" +
            product.productId,
          {
            method: "delete",
          }
        );
      } catch (error) {
        alert("error");
      }
    },
    async getCart(){
      this.products = [];
      try {
          let response = await fetch( "http://localhost:8080/user/getCart/" + this.userID , {
              method: "get", 
          }).then(this.checkStatus)
          .then(this.parseJSON);
          console.log(response);
          this.products = response;
      } catch (error) {
          alert('error');
      }
    },
    incrementQuantity(product) {
      console.log(product.noOfCopies);
      fetch("http://localhost:8080/user/updateCart/" + this.userID, {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          isbn: this.product.productId,
          noOfCopies: product.noOfCopies,
        }),
      });
    },
  },
  created() {
    this.getCart();
  },
};

</script>
<style scoped>
.shopping-cart{
  margin-top: 100px;
}
* {
  box-sizing: border-box;
}

html {
  font-size: 12px;
}

body {
  margin: 20px 0;
  padding: 0;
  font-family: arial, sans-serif;
  overflow: scroll;
}

img {
  max-width: 100%;
  vertical-align: middle;
  border-radius: 4px;
}

a {
  text-decoration: none;
  color: #333333;
}

a:hover {
  color: #f58551;
}

button {
  background-color: #16cc9b;
  border: 2px solid #16cc9b;
  color: #ffffff;
  transition: all 0.25s linear;
  cursor: pointer;
}

button::after {
  position: relative;
  right: 0;
  content: " \276f";
  transition: all 0.15s linear;
}

button:hover {
  background-color: #f58551;
  border-color: #f58551;
}

button:hover::after {
  right: -5px;
}

button:focus {
  outline: none;
}

ul {
  padding: 0;
  margin: 0;
  list-style-type: none;
}

input {
  transition: all 0.25s linear;
}

input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  margin: 0;
}

input {
  outline: none;
}

.container {
  width: 90%;
  margin: 0 auto;
  overflow: auto;
}


/* --- PRODUCT LIST --- */
.products {
  border-top: 1px solid #ddd;
}

.products > li {
  padding: 1rem 0;
  border-bottom: 1px solid #ddd;
}

.row {
  position: relative;
  overflow: auto;
  width: 100%;
}

.col,
.quantity,
.remove {
  float: left;
}

.col.left {
  width: 70%;
}

.col.right {
  width: 30%;
  position: absolute;
  right: 0;
  top: calc(50% - 30px);
}

.detail {
  padding: 0 0.5rem;
  line-height: 2.2rem;
}

.detail .name {
  font-size: 1.2rem;
}

.detail .description {
  color: #7d7d7d;
  font-size: 1rem;
}

.detail .price {
  font-size: 1.5rem;
}

.quantity,
.remove {
  width: 50%;
  text-align: center;
}



.quantity > input {
  display: inline-block;
  width: 60px;
  height: 60px;
  position: relative;
  left: calc(50% - 30px);
  background: #fff;
  border: 2px solid #ddd;
  color: #7f7f7f;
  text-align: center;
  font: 600 1.5rem Helvetica, Arial, sans-serif;
}

.quantity > input:hover,
.quantity > input:focus {
  border-color: #f58551;
}

.close {
  fill: #7d7d7d;
  transition: color 150ms linear, background-color 150ms linear,
    fill 150ms linear, 150ms opacity linear;
  cursor: pointer;
}

.close:hover {
  fill: #f58551;
}

/* --- SUMMARY --- */


.summary {
  font-size: 1.2rem;
  text-align: right;
}

.summary ul li {
  padding: 0.5rem 0;
}

.summary ul li span {
  display: inline-block;
  width: 30%;
}

.summary ul li.total {
  font-weight: bold;
}

.checkout {
  text-align: right;
}

.checkout > button {
  font-size: 1.2rem;
  padding: 0.8rem 2.8rem;
  border-radius: 1.5rem;
}

.empty-product {
  text-align: center;
}

.empty-product > button {
  font-size: 1.3rem;
  padding: 10px 30px;
  border-radius: 5px;
}
.remove button[data-v-c028c34c] {
  background-color: #e14646;
  border: 0;
}


/* --- SMALL SCREEN --- */
@media all and (max-width: 599px) {
  .thumbnail img {
    display: none;
  }

  .quantity > input {
    width: 40px;
    height: 40px;
    left: calc(50% - 20px);
  }

  .remove svg {
    width: 40px;
    height: 40px;
  }
}

/* --- MEDIUM & LARGE SCREEN --- */
@media all and (min-width: 600px) {
  html {
    font-size: 14px;
  }

  .container {
    width: 75%;
    max-width: 960px;
  }

  .thumbnail,
  .detail {
    float: left;
  }

  .thumbnail {
    width: 35%;
  }

  .detail {
    width: 65%;
  }

  .promotion,
  .summary {
    width: 50%;
  }

  .checkout {
    width: 100%;
  }

  .checkout,
  .summary {
    text-align: right;
  }
}





</style>