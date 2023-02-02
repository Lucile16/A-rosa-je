<template>
  <h1>Liste des annonces</h1>
  <div class="container">
    <div v-if="!annonces.length">
      <p>Il n'y a aucune annonce de disponible actuellement</p>
    </div>
    <div v-else>
      <AnnonceCardComponent
        v-for="a in annonces"
        :key="a.id"
        :title="a.title"
        :description="a.description"
      />
    </div>
  </div>
</template>

<script>
import AnnonceCardComponent from "../components/AnnonceCardComponent.vue";
import axios from "axios";

export default {
  name: "ListeAnnonces",
  components: {
    AnnonceCardComponent,
  },
  data() {
    return {
      annonces: {
        1: {
          title: "ceci est un titre",
          description: "ceci est une description",
        },
        2: {
          title: "ceci est un titre2",
          description: "ceci est une description",
        },
      },
    };
  },
  created() {
    this.fetchAnnonces();
  },
  methods: {
    async fetchAnnonces() {
      try {
        const response = await axios.get("http://localhost:8080/annonces");
        console.log(response.data._embedded.annonces);
        this.annonces = response.data._embedded.annonces;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
  gap: var(--gap);
}
</style>
