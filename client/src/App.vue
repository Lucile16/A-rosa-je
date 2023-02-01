<template>
  <AnnonceItem/>
</template>

<script>
import AnnonceItem from "./components/AnnonceItem.vue";

export default {
  name: "App",
  components: {
    AnnonceItem
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
</style>
