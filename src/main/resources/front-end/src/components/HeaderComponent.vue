<template>
  <header>
    <h1>
        My Photoalbum
    </h1>
    
    <div class="admin-link">
        <a href="http://localhost:8080/" target="_blank">Go to admin page</a>
    </div>
  </header>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
    header {
        padding-block: 3rem;
        background-color: #111;
        position: fixed;
        top: 0;
        left: 0;
        right: 0;

        
        h1 {
            text-align: center;
            font-size: 4rem;
            font-family: 'Josefin Sans', sans-serif;
            pointer-events: none;
            user-select: none;
        }

        div.admin-link {
          text-align: end;
          padding-right: 4rem;

          a {
            text-decoration: none;
            font-size: 1.5rem;
            position: relative;

            &::before {
              content: "";
              height: 3px;
              width: 0;
              background-color: whitesmoke;
              position: absolute;
              left: 0;
              bottom: 0;
              transition: .3s;
            }

            &:hover::before {
              width: 100%;
            }

          }
        }

    }
</style>