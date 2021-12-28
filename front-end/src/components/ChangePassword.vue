<template>
    <div class="container">
        <div class=" changePassword" >
        <form>
            <div class="form-group">
                <label>Old Password</label>
                <input type="password"  v-model="oldPassword" class="form-control form-control-lg shadow-none" placeholder="old password" />
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password"  v-model="password" class="form-control form-control-lg shadow-none" placeholder="new password" />
            </div>

            <div class="form-group">
                <label>Confirm Password</label>
                <input type="password"  v-model="confirmPassword" class="form-control form-control-lg shadow-none" placeholder="confirm Password" />
            </div>

            <div class="form-group ">
                <div>
              <button type="button" class="btn btn-primary"  @click.prevent="confirm">Save</button>
            <button type="button" class="btn btn-outline-dark">Cancel</button>
           </div>
            </div>
        </form>
            
    </div>
    </div>
</template>

<script>
    export default {
        name: 'ChangePassword',
        data() {
            return {
                confirmPassword:'',
                oldPassword:'',
                password:'',
                
            }
        },
    }
</script>

<style scoped>  
  
    label {
        font-weight: 500;
    }
    .changePassword{
        display: block;
        background-color: #FFF;
        height: auto;
        width: 500px;
        padding: 20px;
        border-radius: 5px;
    }
    form h3{
        margin-bottom: 0;
    }
    form span {
        font-size: 13px;
    }

    .form-group{
        display: flex;
        flex-direction: row;
        justify-content: left;
        align-items: center;
        margin-top: 15px;
        font-size: 10px;
    }
    .form-group label{
        width: 80px;
    }
    .form-group input{
        font-size: 13px;
        padding: 10px;
    }

    .form-control:focus,
    .btn:focus,.btn:active {
        border-color:#CCC;
        outline:0 !important;
        -webkit-box-shadow:none;
        box-shadow:none;
    }


    .btn-group-lg>.btn, .btn-lg 
    {width: 100%;}
.container
{
    width: 35%;
    padding-top: 30px;
}
div button {
  margin-right: 20px;
  min-width: 100px;
}
 
</style>