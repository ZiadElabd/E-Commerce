<template>
  <div>
    <Navbar />
    <div class="container">
      <div v-if="orders.length > 0">
        <div class="table">
          <div class="layout-inline row th">
            <div class="col col-pro">Order ID</div>
            <div class="col col-qty align-center">Quantity</div>
            <div class="col col-price align-center">Total Price</div>
            <div class="col">Status</div>
          </div>

          <div
            class="layout-inline row"
            v-for="order in orders"
            :key="order.OrderId"
          >
            <div class="col col-pro layout-inline">
              <p>{{ order.orderID }}</p>
            </div>
            <div class="col col-qty layout-inline">
              <p>{{ order.noOfItems }}</p>
            </div>
            <div class="col col-price col-numeric align-center ">
              <p>{{ order.totalPrice }}$</p>
            </div>
            <div class="col col-total col-numeric">
              <p>{{ order.date }}</p>
            </div>
          </div>
        </div>
      </div>
      <div v-else class="empty-product">
        <h3>There are no orders Yet</h3>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";
export default {
  name: "OrderPage",
  isAdmin: true,
  components: {
    Navbar,
  },
  data() {
    return {
      orders: [],
    };
  },
  computed: {
    isAdmin() {
      return this.$store.state.role;
    },
    userID() {
      return this.$store.state.userID;
    },
  },
  methods: {
    parseJSON: function(resp) {
      return resp.json();
    },
    checkStatus: function(resp) {
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
    async getOrders() {
      this.orders = [];
      try {
        let response = await fetch(
          "http://localhost:8080/admin/getOrders/" + this.userID,
          {
            method: "get",
          }
        )
          .then(this.checkStatus)
          .then(this.parseJSON);
        console.log(response);
        this.orders = response;
      } catch (error) {
        alert("error");
      }
    },
  },
  created() {
    console.log("created");
    this.getOrders("Clothing");
  },
};
</script>

<style scoped>
html {
  background: #bbc3c6;
  font: 62.5%/1.5em "Trebuchet Ms", helvetica;
}
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
  background-color: #4caf50;
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
  background: #3d67f3;
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
  box-shadow: 0 3px 0 rgba(59, 154, 198, 1);
}

.btn:hover {
  box-shadow: 0 3px 0 rgba(59, 154, 198, 0);
}

.btn-update {
  float: right;
  margin: 0 0 1.5em 0;
}

.transition {
  transition: all 0.3s ease-in-out;
}

.empty-product {
  text-align: center;
}

.empty-product > button {
  font-size: 1.3rem;
  padding: 10px 30px;
  border-radius: 5px;
}

@media screen and (max-width: 755px) {
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

@media screen and (max-width: 580px) {
}
</style>
