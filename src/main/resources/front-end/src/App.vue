<template>
  <div>
    <HeaderComponent />
    <PhotoIndexComponent />
  </div>
</template>

<script>
import PhotoIndexComponent from './components/PhotoIndexComponent.vue'
import HeaderComponent from './components/HeaderComponent.vue'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    PhotoIndexComponent,
  }
}
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&family=Nunito:wght@200;400;500;600;700;900&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Nunito', sans-serif;
  color: whitesmoke;
}

body {
  background-color: #111;
}

</style>
