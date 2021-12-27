<template>
    <div class="container">
        <div class=" signin" >
        <form>
            <div class="icon">
                <img src="../assets/market.jpg" alt="">
            </div>
            <div class="form-group">
                <label>Login</label>
                <input type="email" v-model="form.userName" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" v-model="form.password" class="form-control form-control-lg shadow-none" placeholder="password" />
            </div>
            <div class="form-group ">
                 <b-button variant="primary" @click.prevent="login" class="btn  btn-lg btn-full "> Log in </b-button>
                 <b-button variant="light" class="btn  btn-lg btn-full "><router-link to="/signup">Sign Up</router-link></b-button>
        </div>
        </form>
            
    </div>
    </div>
</template>

<script>
    export default {
        name: 'SignIn',
        data() {
            return {
                form:{
                    userName:'',
                    password:'',
                },
                checkState: false,
            }
        },
        methods:{
            parseJSON: function (resp) {
                return resp.text();
            },
            checkStatus1: function (resp) {
                console.log('status');
                if (resp.status >= 200 && resp.status < 300) {
                    console.log('good status');
                    return resp;
                }
                console.log('bad status');
                return this.parseJSON(resp).then((resp) => {
                    throw resp;
                });
            },
            async login(){
                try {
                    const response = await fetch( "http://localhost:5050/signin/" , {
                        method: "post" , 
                        headers: { "Content-Type": "application/json" },
                        body: JSON.stringify(this.form)
                    }).then(this.checkStatus1)
                    .then(this.parseJSON)
                    // console.log('ziad');
                    // console.log(response);
                    this.$store.commit('saveUserData',{
                        _id: response,
                        _name: this.form.userName
                    });
                    console.log(this.$store.state.userID);
                    this.$store.dispatch("getImage");
                    this.$router.push({ name: "Home" });
                } catch (error) {
                    alert('error');
                } 
            
            },

        }
    }
</script>
<style scoped>
.container
{
    width: 30%;
    padding-top: 30px;
    }
.form-group
{
    margin-bottom: 10px;
}
.icon{
    width: 200px;
    height: 200px;
    margin: auto;
}

.icon img{
    width: 100%;
    height: 100%;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled){
    margin: 10px 0;
}
a {
    color: inherit;
    text-decoration: none;
}



</style>