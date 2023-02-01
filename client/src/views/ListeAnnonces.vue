<template>
  <div>
    <h1>Liste des annonces</h1>
    <AnnonceItem />
  </div>
</template>

<script>
import "./assets/css/style.css";
import AnnonceItem from "../components/AnnonceItem.vue";

export default {
  name: "ListeAnnonces",
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
