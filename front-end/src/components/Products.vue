<template>

<div class="products">
       <Navbar />
    
  <div class="container">
        <div class="row">
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">002</div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">002</div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">002</div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">002</div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">002</div>
                    </div>
                </div> 
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">003</div>
                    </div>
                </div> 
                
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">004</div>
                    </div>
                </div> 
                
                <div class="col-sm-3">
                    <div class="box-container"> 
                    <div class="box-img"> 
                        <img src="../assets/market.jpg" />
                        <div class="box-price">$12345</div>
                    </div>
                    <h4 class="box-title">box title or name </h4>  
                    <div class="box-heading text-uppercase">Category</div>
                    <div class="box-btns">
                        <a class="btn btn-primary text-uppercase">view</a>
                    </div>
                    <div class="box-id">001</div>
                    </div>
                </div>  
        </div>
  </div>




</div>
</template>

<script>
import Navbar from "../components/nbar.vue";
export default {
  name: "Products",
  components: {
    Navbar,
  },
};
</script>
<style scoped>
.box-container {
  text-align: center;
  width: 100%;
  border: 1px solid #999;
  margin: 25px 0;
  margin-top: 50px;
  padding: 6px 15px 0;
}
.row{
    margin-top: 80px;
}
.box-container .box-id {
  background-color: #eee;
  display: block;
  padding: 6px 15px;
  margin-top: 10px;
}
.box-container .box-img {
  margin-top: -35px;
  position: relative;
}
.box-container .box-price {
  display: inline-block;
  background-color: #3498db;
  border-radius: 0px;
  padding: 4px 10px;
  margin: 15px auto 0;
  color: #fff;
  position: absolute;
  top: 0;
  left: 0;
}
.box-container .box-title {
  font-size: 14px;
  text-transform: uppercase;
  font-weight: bold;
}
.box-container .box-heading {
  margin: 10px 0;
}
.box-container .btn {
  font-size: 13px;
}
.box-container img {
  display: block;
  max-width: 100%;
}
</style>