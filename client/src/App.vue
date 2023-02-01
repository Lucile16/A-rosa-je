<template>
  <AnnonceItem />
</template>

<script>
import "./assets/css/style.css";
import AnnonceItem from "./components/AnnonceItem.vue";

export default {
  name: "App",
  components: {
    AnnonceItem,
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--color-primary);
}

body {
  margin: 0;
}
</style>
