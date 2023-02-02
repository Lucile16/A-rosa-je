<template>
  <h1>Liste des annonces</h1>
  <div class="container">
    <AnnonceCardComponent
      v-for="a in annonces"
      :key="a.id"
      :title="a.title"
      :description="a.description"
    />
  </div>
</template>

<script>
import AnnonceCardComponent from "../components/AnnonceCardComponent.vue";

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
