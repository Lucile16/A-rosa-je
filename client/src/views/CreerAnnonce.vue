<template>
  <h1 class="text-center" style="color: var(--color-primary-dark)">
    Création d'une annonce
  </h1>
  <div class="d-flex flex-column align-items-center mb-4">
    <form
      class="row g-3 justify-content-center container text-center mt-2 needs-validation"
      action="index.php?page=3"
      method="POST"
      novalidate
    >
      <div class="col-md-10">
        <div class="input-group has-validation">
          <span class="input-group-text" id="inputGroupPrepend"
            >Nom de l'annonce</span
          >
          <input
            type="text"
            class="form-control"
            v-model="annonce.titre"
            id="validationCustomUsername"
            aria-describedby="inputGroupPrepend"
            maxlength="90"
            required
          />
          <div class="invalid-feedback">Veuillez remplir ce champs</div>
        </div>
      </div>

      <div class="col-md-10">
        <input type="file" />
      </div>

      <div class="col-md-10">
        <label>Prendre une photo :</label>
        <CameraComponent
          class="border-primary p-2 w-100"
          :items="annonce.items"
        ></CameraComponent>
      </div>

      <div class="mt-5 col-md-10">
        <span class="input-group-text" id="inputGroupPrepend">Description</span>
        <!-- <label for="validationTextarea" class="form-label fs-6 fw-normal" style="color: #212529;">Description</label> -->
        <textarea
          class="form-control"
          v-model="annonce.description"
          id="validationTextarea"
          rows="8"
          required
        ></textarea>
        <div class="invalid-feedback">Veuillez remplir ce champs</div>
      </div>

      <div class="mt-5 col-md-3">
        <div class="input-group has-validation">
          <span class="input-group-text" id="inputGroupPrepend"
            >Numéro de rue</span
          >
          <input
            type="number"
            class="form-control"
            v-model="annonce.adresse.numero"
            id="validationCustomUsername"
            aria-describedby="inputGroupPrepend"
            required
          />
          <div class="invalid-feedback">Veuillez remplir ce champs</div>
        </div>
      </div>

      <div class="mt-5 col-md-7">
        <div class="input-group has-validation">
          <span class="input-group-text" id="inputGroupPrepend">Rue/Voie</span>
          <input
            type="text"
            class="form-control"
            v-model="annonce.adresse.rue"
            id="validationCustomUsername"
            aria-describedby="inputGroupPrepend"
            maxlength="90"
            required
          />
          <div class="invalid-feedback">Veuillez remplir ce champs</div>
        </div>
      </div>

      <div class="mt-5 col-md-3">
        <div class="input-group has-validation">
          <span class="input-group-text" id="inputGroupPrepend"
            >Code postal</span
          >
          <input
            type="number"
            class="form-control"
            v-model="annonce.adresse.codePostal"
            id="validationCustomUsername"
            aria-describedby="inputGroupPrepend"
            required
          />
          <div class="invalid-feedback">Veuillez remplir ce champs</div>
        </div>
      </div>

      <div class="mt-5 col-md-7">
        <div class="input-group has-validation">
          <span class="input-group-text" id="inputGroupPrepend">Ville</span>
          <input
            type="text"
            class="form-control"
            v-model="annonce.adresse.ville"
            id="validationCustomUsername"
            aria-describedby="inputGroupPrepend"
            maxlength="90"
            required
          />
          <div class="invalid-feedback">Veuillez remplir ce champs</div>
        </div>
      </div>

      <div class="mt-5 col-md-5">
        <span class="input-group-text" id="inputGroupPrepend">Plante</span>
        <!-- <label for="validationCustom04" class="form-label fs-6 fw-normal" style="color: #212529;">Plante</label> -->
        <select
          class="form-select"
          v-model="selectedPlant"
          id="validationCustom04"
          required
        >
          <option selected disabled value="">Choisissez une plante...</option>
          <option v-for="plant in plants" :key="plant.id" :value="plant">
            {{ plant.nom }}
          </option>
        </select>
        <div class="invalid-feedback">Veuillez sélectionner un niveau</div>
      </div>

      <div class="mt-5">
        <button
          class="btn btn-success me-5"
          type="submit"
          @click.prevent="submitAnnonce"
        >
          Valider
        </button>
        <button class="btn btn-danger" type="reset">Annuler</button>
      </div>
    </form>
  </div>
</template>

<script>
//Fonction Bootstrap qui vérifie si les champs sont valides
(function () {
  //Le mode strict lève des exceptions si erreur et exécute le code plus rapidement
  "use strict";
  var forms = document.querySelectorAll(".needs-validation");

  //Permet de convertir des objets/collections similaires à des tableaux, en un nouveau tableau
  Array.prototype.slice.call(forms).forEach(function (form) {
    form.addEventListener(
      "submit",
      function (event) {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }

        form.classList.add("was-validated");
      },
      false
    );
  });
})();

import axios from "axios";
import CameraComponent from "../components/CameraComponent.vue";

export default {
  name: "CreerAnnonce",
  components: {
    CameraComponent,
  },
  data() {
    return {
      annonce: {
        items: [],
        titre: null,
        description: null,
        adresse: {
          numero: null,
          rue: null,
          codePostal: null,
          ville: null,
        },
      },
      plants: [],
      selectedPlant: null,
    };
  },
  created() {
    this.fetchPlants();
  },
  methods: {
    async submitAnnonce() {
      if (this.selectedPlant) {
        try {
          const response = await axios.post(
            "http://localhost:8080/annonces",
            this.annonce
          );
          console.log(response.data);
          const response2 = await axios.put(
            response.data._links.self.href + "/plantes",
            this.selectedPlant._links.self.href,
            {
              headers: {
                "Content-Type": "text/uri-list",
              },
            }
          );
          console.log(response2.data);
        } catch (error) {
          console.error(error);
        }
      } else {
        console.log("No selected plant found");
      }
    },

    async fetchPlants() {
      try {
        const response = await axios.get("http://localhost:8080/plantes");
        console.log(response.data._embedded.plantes);
        this.plants = response.data._embedded.plantes;
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>
