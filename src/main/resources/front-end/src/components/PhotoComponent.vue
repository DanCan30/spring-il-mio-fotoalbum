<template>
  <div class="card">
    <h3>
      {{ photo.title }}
    </h3>
    <div class="img-container">
      <img :src="photo.imageUrl" :alt="photo.title + ' placeholder'">
    </div>
    <div class="info-container">
      <span class="tag-container">
        #{{ photo.tag }} 
      </span> 
      <span v-if="photo.categories.length >0">

        - 
        <span v-for="category in photo.categories" :key="category.id">
          {{ category.name + " "}} 
        </span>
      </span>
        <div class="description-container">
          Description: 
          <p>
            {{ photo.description }}
          </p>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "PhotoComponent",
    props: {
        photo: Object,
    }
}
</script>

<style lang="scss" scoped>

  div.card {
    width: 100%;
    padding: 1rem;
    cursor: pointer;
    transition: .2s;

    h3 {
      text-transform: uppercase;
      text-align: center;
    }
    div.img-container {
      width: 90%;
      margin: auto;

      img {
        max-width: 100%;
      }
    }

    div.info-container {
      padding-left: 1.5rem;
      span.tag-container {
        text-transform: uppercase;
        color: rgb(0, 153, 255);
      }
    }

    div.description-container {
      padding-top: 1rem;
    }
  }
</style>