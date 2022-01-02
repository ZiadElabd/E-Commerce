<template>
       <div>
            <Navbar />
            <div class="product">
                <div class="photo">
                    <img src="../assets/market.jpg" alt="">
                </div>
                <div class="description">
                <div class="name">
                        <h1>Name</h1>
                        <p>;pskjhf kjhfj djghjf dlokjuisdkh djhdjnd jfhjf posdujfik dikyhfu diyud fijuyhdju</p>
                </div>
                    
                    <div class="price">
                        <div>Quantity: 8</div>
                        <div>Price: 876$</div>      
                    </div>
                    <br>
                    <button type="button" class="btn btn-primary"  @click.prevent="addToCart">ADD TO CART</button>
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
    computed: {
        isAdmin(){
            return this.$store.state.role;
        }
    },
    
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Prompt&family=Rubik:wght@500&family=Titillium+Web:ital,wght@0,200;1,300&display=swap');
.product{
    width: 70%;
    height: 400px;
    background-color: #EEEEEE;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    position: absolute;
    display: flex;
    justify-content: space-between;
    position: abslute;
font-family: Roboto,Helvetica Neue,Helvetica,Tahoma,Arial,PingFang SC,Microsoft YaHei;
}
.photo , .description{
    width: 40%;
}
.description{
    position: absolute;
    top: 50%;
    left: 75%;
    transform: translate(-50%,-50%);
    width: 50%;
}
img{
    width: 100%;
    height: 100%;
}
.name , .price 
{
    width: 80%;
    padding: 20px 0;
    border-bottom: 4px solid #DDD;
}
.name h1{
    font-family: 'Rubik', sans-serif;
}

</style>