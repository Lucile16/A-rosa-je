<template>
  <AnnonceComponent :annonce="annonce" />
</template>

<script>
import AnnonceComponent from "../components/AnnonceComponent.vue";
import axios from "axios";
export default {
  name: "DetailsAnnonce",
  components: {
    AnnonceComponent,
  },
  data() {
    return {
      annonce: {},
    };
  },
  created: function () {
    this.fetchAnnonce();
  },
  methods: {
    fetchAnnonce: async function () {
      try {
        const response = await axios.get(
          "http://localhost:8080/annonces/" + this.$route.params.id
        );
        console.log(response.data);
        this.annonce = response.data;
        // console.log("ok");
        // console.log(self.commits[0].html_url);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>
