<template>
  <h1>Liste des annonces</h1>
  <div class="d-flex justify-content-center">
    <div
      class="alert alert-primary fade show w-auto mt-4 d-inline-flex"
      v-if="!annonces.length"
      role="alert"
    >
      <div>Il n'y a aucune annonce disponible actuellement</div>
    </div>
    <div class="row justify-content-center m-2" v-else>
      <AnnonceCardComponent v-for="a in annonces" :key="a.id" :annonce="a" />
    </div>
  </div>
</template>

<script>
import AnnonceCardComponent from "../components/AnnonceCardComponent.vue";
import axios from "axios";
import swal from "sweetalert";
export default {
  name: "ListeAnnonces",
  components: {
    AnnonceCardComponent,
  },
  data() {
    return {
      annonces: [],
      config: {
        auth: {
          username: "admin",
          password: "password",
        },
      },
      access_token: "YWRtaW46cGFzc3dvcmQ",
    };
  },
  created() {
    this.fetchAnnonces();
  },
  methods: {
    async fetchAnnonces() {
      try {
        const response = await axios.get("http://localhost:8080/annonces", {
          auth: {
            username: "admin",
            password: "password",
          },
        });
        if (
          response.data._embedded.annonces !== null ||
          response.data._embedded.annonces.length
        ) {
          this.annonces = response.data._embedded.annonces;
        }
      } catch (error) {
        swal(
          "Veuillez nous excuser...",
          "Une erreur est survenue de notre côté",
          "error"
        );
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.alert-primary {
  --bs-alert-color: var(--color-secondary) !important;
  --bs-alert-bg: var(--color-background2) !important;
  --bs-alert-border-color: var(--color-border) !important;
}
</style>
