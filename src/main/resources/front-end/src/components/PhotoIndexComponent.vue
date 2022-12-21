<template>
    <main>

        <a href="http://localhost:8080/" target="_blank">Go to admin page</a>

        <div class="search-container">

            <label for="query">Search</label>
            <input type="text" name="query" id="query" v-model="query" @keyup.enter="searchPhoto">
            <button @click="searchPhoto">GO</button>
        </div>

        <div class="container">
            
            <div class="photo-container" :class="photo.isVisible ? '' : 'hidden'" v-for="photo in photos" :key="photo.id">

                <PhotoComponent class="clown" :photo="photo" @click="showDetails(photo.id)"/>

            </div>
            
        </div>

        <div>
            <PhotoDetailsComponent v-if="activePhoto != null" @hidePage="hidePage" :photo="activePhoto"/>
        </div>

    </main>
</template>

<script>
import PhotoComponent from "./PhotoComponent.vue";
import PhotoDetailsComponent from "./PhotoDetailsComponent.vue";
import axios from "axios";

const API_URL = "http://localhost:8080/api/1/";

export default {

    name: "PhotoIndexComponent",

    components: {
        PhotoComponent,
        PhotoDetailsComponent
    },

    data: function() {
        return {
            photos: [],
            query: "",
            activePhoto: null,
        }
    },
    methods: {

        hidePage(value) {
            this.activePhoto = value;
        },

        getAllPhotos() {
            axios.get(API_URL + "photo/all")
            .then(result => {
                this.photos = result.data;
            })
        },
        searchPhoto() {
            axios.get(API_URL + "photo/search", {params : {query: this.query}})
            .then(result => {
                this.photos = result.data;
            });
            this.query = "";
        },
        showDetails(id) {

            for(let i = 0; i < this.photos.length; i++) {
                
                const photo = this.photos[i];

                if(photo.id == id) {
                    this.activePhoto = photo;
                }
            }
        }
    },

    created() {
        this.getAllPhotos()
    }
}
</script>

<style lang="scss" scoped>

.hidden {
    display: none;
}

main {
    margin-block: 10rem;

    div.search-container {
        max-width: 80%;
        margin: 2rem auto;

        input {
            margin-left: .5rem;
            border: 0;
            border-bottom: 1px solid whitesmoke;
            outline: none;
            background-color: transparent;
            font-size: 1rem;
        }

        button {
            background-color: transparent;
            border: none;
            margin-left: .5rem;
            cursor: pointer;
            font-size: 1.25rem;
            transition: .3s;

            &:hover {
                font-weight: bolder;
            }
        }
    }
    div.container {
        display: flex;
        flex-wrap: wrap;
        max-width: 80%;
        margin: auto;
        gap: 4rem;
        justify-content: center;

        div.photo-container {
            width: 30%;
            border: 1px solid grey;
            

            &:hover {
            background-color: #333;
            }
        }
    }
}
</style>