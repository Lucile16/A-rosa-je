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

body {
  margin: 0;
}
</style>
