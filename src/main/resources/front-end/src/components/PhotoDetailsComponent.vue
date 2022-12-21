<template>
  <section class="wrapper" @click.self="$emit('hidePage', null)">
    <div class="photo">
        <div class="left-side">
            <img :src="photo.imageUrl" :alt="photo.title + ' photo'">
        </div>
        <div class="right-side">
            <h2>
                {{ photo.title }}
            </h2>

            <section class="comment-section">
                <h4>Comments</h4>
                <ul>
                    <li v-for="comment in photo.comments" :key="comment.id">
                        {{ comment.text }}
                    </li>
                </ul>
            </section>

            <div class="comment-input-container">
                <input type="text" name="comment" id="comment-input" placeholder="Add a comment..." v-model="commentValue" @keyup.enter="addComment(photo.id)">
                <button @click="addComment(photo.id)">ADD</button>
            </div>
        </div>
    </div>
</section>
</template>

<script>

import axios from "axios";

const API_URL = "http://localhost:8080/api/1/";

export default {
/* eslint-disable */
    name: "PhotoDetailsComponent",
    props: {
        photo: Object
    },
    data() {
        return {
            newComment: {},
            commentValue: "",
            comments: [],
            
        }
    },
    methods: {
        addComment(id) {

            if(this.commentValue == "")
            return

            this.newComment = {text: this.commentValue, photo_id: id}

            axios.post(API_URL + "comments/add/photo/" + id, this.newComment)
            .then(result => {
                console.log(result.data)
                this.comments.unshift(result.data);
                this.commentValue = "";
                this.getAllComments(id);
            }).catch(e => console.error(e));

        },

        getAllComments(id) {
            axios.get(API_URL + "comments/all/photo/" + id)
            .then(result => {
                this.photo.comments = result.data;
            })
        }
    },
    mounted() {
        this.getAllComments(this.photo.id)
    }
}
</script>

<style lang="scss" scoped>

    section.wrapper {
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        backdrop-filter: blur(20px);
        display: flex;
        justify-content: center;
        align-items: center;

        div.photo {
            background-color: #111;
            width: 80%;
            display: flex;
            height: 50%;

            .left-side {
                width: 75%;
                height: 100%;

                img {
                    width: 100%;
                    height: 100%;
                    object-fit: cover;
                    display: block;
                }
            }
            .right-side {
                width: 25%;
                height: 100%;
                display: flex;
                flex-direction: column;

                h2 {
                    text-align: center;
                    font-size: 3rem;
                    text-transform: uppercase;
                    height: 12%;
                    padding-top: 1rem;
                }

                section.comment-section {
                    height: 80%;
                    padding-left: 1rem;
                    overflow-y: auto;

                    ul {
                        padding-left: 1rem;
                        list-style: none;

                        li {
                            border-bottom: 1px solid rgba(#fff, .2);
                            width: 80%;
                        }
                    }
                }

                div.comment-input-container {
                    width: 90%;
                    margin: auto;
                    height: 8%;
                    display: flex;
                    padding-bottom: 1rem;
                    
                    input {
                        position: relative;
                        width: 90%;
                        height: 100%;
                        font-size: 1.5rem;
                        background-color: transparent;
                        outline: none;
                        border: none;
                        padding-left: .25rem;
                        border-bottom: 3px solid rgba(#fff, .7);
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
            }
        }
    }
</style>