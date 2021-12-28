<template>
  <nav class="navbar navbar-dark bg-primary navbar navbar-expand-lg">
     <div class="container">
       <ul class="categories navbar-nav  mr-auto">
          <li class="category_item">
            Clothing
          </li>
          <li class="category_item">
            Electronics
          </li>
          <li class="category_item">
            Shoes
          </li>
          <li class="category_item">
            Watches
          </li>
          <li class="category_item">
            Jewallery
          </li>
          <li class="category_item">
            Sports
          </li>
          
        </ul>
      <div class="search">
          <form class="form-inline my-2 my-lg-0 navbar-nav">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
          </form>
      </div>

      <div class="setting">
          <b-dropdown>
            <template #button-content>
                  <em><font-awesome-icon icon="cog" /></em>
            </template>
            <b-dropdown-item to="/Settings">Settings</b-dropdown-item>
                <b-dropdown-item  @click.native="reset" to="/">Log Out</b-dropdown-item>
          </b-dropdown>
      </div>
     </div>

  </nav>
</template>
<script>
export default {
  name: "Navbar",
  computed: {
    userName() {
      console.log("in nav bar => " + this.$store.state.userName);
      return this.$store.state.userName;
    },
    userImage(){
      return this.$store.state.userImage;
    }
  },
  methods:{
    reset(){
      fetch(
          "http://localhost:5050/logout/" + this.$store.state.userID ,
          {
            method: "post",
          }
      );
      this.$store.commit('reset');
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
  },
  created() {
    console.log("nav created");
    console.log("in nav bar => " + this.$store.state.userName);
  },
};
</script>

<style scoped>
.navbar {
  top: 0;
  width: 100%;
  position: fixed;
}
.nav li a {
  color: #898b8c;
}
.nav {
  font-size: 110%;
}

.navbar-brand a {
  color: #ee1144;
  font-weight: bolder;
  font-family: "Lobster", cursive;
  text-decoration: none;
}
.nav li a:hover,
.navbar-brand:hover {
  color: #ee1144;
}
.nav li a:hover {
  font-size: 97.5%;
}

div > .navbar-brand {
  font-family: "Lobster", cursive;
}
.nav-link a:focus {
  color: #ee1144;
  font-size: 97.5%;
}
.container {
  width: 80%;
}
.categories li{
  display: block;
  padding: 0 10px;
  color: #FFF;
  cursor: pointer;
  margin: 0 10px;
}
.search button{
  color: #FFF;
  border: 1px solid #FFF;
  width: 150px;
  margin-left: 10px;
}

.btn-secondary {
    color: #FFF;
    background-color: inherit;
    border-color: none;
}
.btn-secondary:hover {
    color: #FFF;
    background-color: inherit;
    border-color: none;
}
.btn-check:active+.btn-secondary, .btn-check:checked+.btn-secondary, .btn-secondary.active, .btn-secondary:active, .show>.btn-secondary.dropdown-toggle {
    color: #fff;
    background-color: inherit;
    border-color: none;
}
nav{
  display: flex;
  justify-content: space-between;
}
</style>
