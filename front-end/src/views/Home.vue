<template>
  <div class="home">
    <Navbar />
    <div class="container">

    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";
export default {
  name: "Home",
  data() {
    return {
    };
  },
  components: {
    Navbar,
  },
}
 
</script>
<style scoped>
.home_item {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.container {
  width: 60%;
}
.sender {
  font-size: 13px;
}
.name {
  display: flex;
}
.name .name_photo,
.name .answer {
  margin: 5px;
}
.name .myname {
  margin-top: 6px;
  font-size: 90%;
}
.name_time {
  padding-left: 4px;
}
.name .time {
  font-size: 70%;
  margin-top: -7px;
  color: #b9b9bb;
}
.like {
  margin-left: -10px;
  margin-top: 5px;
  font-size: 150%;
}
.btn span.grey {
  color: #cdcdd9;
}
.btn span.red {
  color: #ee4c22;
}
.like .btn {
  border: 0;
  font-size: 20px;
}
</style>
