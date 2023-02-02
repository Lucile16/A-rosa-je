<template>
  <div>
    <h1>Liste des annonces</h1>
    <AnnonceComponent />
  </div>
</template>

<script>
import "../assets/css/style.css";
import AnnonceComponent from "../components/AnnonceComponent.vue";

export default {
  name: "ListeAnnonces",
  components: {
    AnnonceComponent,
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
