<template>
      <div>
          <Navbar />
        <div class="product">
            <div class="photo">
                
                <img :src="profileURL" alt="">
            </div>
            <div class="description">
                <div class="changeprofile ">
            <input
              type="file"
              @change="onprofileselected"
              style="display:none"
              ref="fileinput"
            />
            <span @click="$refs.fileinput.click()">Change Product</span>
          </div>
            </div>

            
        </div>
      </div>
</template>
<script>
import Navbar from "../components/nbar.vue";
export default {
     components: {
    Navbar,
  },
     data() {
    return {
      selectedfile: "",
      profileURL: "",
      coverURL: "",
      profilePhoto:'',
      coverPhoto:'',
      profileSelected: false,
      coverSelected: false,
      allSettings: {
        firstName:"",
        lastName:"", 
        address: "",
        Phone: ""
      },
    };
  },
    methods:{
         onprofileselected: function(event) {
            this.profileSelected = true;
            this.allSettings.profile = event.target.files[0];
            let fd = new FormData();
            fd.append("image", this.allSettings.profile);
            this.profilePhoto = fd;
            this.getImageBase64(this.allSettings.profile);
            },
            getImageBase64: function(file) {
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.profileURL = reader.result;
      };
      reader.error = () => {
        alert("Error !!!");
      };
    },
    }
}
</script>
<style scoped>

.product{
    width: 90%;
    height: 600px;
    background-color: #EEEEEE;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    position: absolute;
    display: flex;
    justify-content: space-between;
}
.photo , .description{
    width: 40%;
}
.description{
    margin-top: 10%;
    width: 50%;
}
img{
    width: 100%;
    height: 100%;
}
.paddingwithborder {
  padding-bottom: 20px;
  border-bottom: 6px solid #ddd;
}

.changeprofile span {
  cursor: pointer;
  color: #ee1144;
  font-size: 18px;
}
.changeprofile .b-avatar {
  width: 4rem;
  height: 4rem;
  margin: 10px 10px 10px 0;
}

</style>