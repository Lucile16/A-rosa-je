<template>
  <h1>Création d'une annonce</h1>
  <div v-if="!data.length">
    <div class="d-flex flex-column align-items-center">
      <!-- Trouver comment revenir sur cette page sans avoir à réactualiser la page quand on a soumis le formulaire -->
      <form
        class="row g-3 justify-content-center container text-center mt-2"
        v-on:submit.prevent="submitAnnonce"
        method="POST"
      >
        <div class="col-md-10">
          <p class="text-end">*champs obligatoires</p>
          <div class="input-group has-validation">
            <span class="input-group-text">Nom de l'annonce*</span>
            <input
              type="text"
              class="form-control"
              v-model="annonce.titre"
              maxlength="90"
              placeholder="Garde d'un rosier en pot"
              required
            />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="col-md-10">
          <input class="form-control" type="file" id="formFile" />
        </div>

        <div class="col-md-10">
          <label>Prendre une photo :</label>
          <CameraComponent
            class="border-primary p-2 w-100"
            :items="annonce.items"
          ></CameraComponent>
        </div>

        <div class="mt-5 col-md-10">
          <div class="has-validation">
            <span class="input-group-text">Description*</span>
            <textarea
              class="form-control"
              v-model="annonce.description"
              rows="8"
              placeholder="A arroser 2 à 3 fois par semaine"
              required
            ></textarea>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3" id="numero">
          <div class="input-group has-validation">
            <span class="input-group-text">Numéro de rue/voie*</span>
            <input
              type="number"
              class="form-control"
              v-model="annonce.adresse.numero"
              placeholder="1"
              min="1"
              max="999"
              required
            />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7" id="voie">
          <div class="input-group has-validation">
            <span class="input-group-text">Rue/Voie*</span>
            <input
              type="text"
              class="form-control"
              v-model="annonce.adresse.rue"
              maxlength="90"
              placeholder="rue de la rose"
              required
            />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3" id="cp">
          <div class="input-group has-validation">
            <span class="input-group-text">Code postal*</span>
            <input
              type="number"
              class="form-control"
              v-model="annonce.adresse.codePostal"
              v-on:change="checkCP"
              id="cp"
              placeholder="44000"
              required
            /> <!-- checkCP vérifie que l'utilisateur tape un code postal valide -->
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7" id="ville">
          <div class="input-group has-validation">
            <span class="input-group-text">Ville*</span>
            <input
              type="text"
              class="form-control"
              v-model="annonce.adresse.ville"
              maxlength="90"
              placeholder="Nantes"
              onkeydown="return /[a-z]/i.test(event.key)"
              required
            /> <!-- onkeydown permet à l'utilisateur de taper uniquement des lettres -->
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-5">
          <span class="input-group-text">Plante*</span>
          <select class="form-select" v-model="selectedPlant" placeholder="jkfdljgkl" required>
            <option selected disabled value="">Choisissez une plante...</option>
            <option v-for="plante in plantes" :key="plante.id" :value="plante">
              {{ plante.nom }}
            </option>
          </select>
          <div class="invalid-feedback">Veuillez sélectionner une plante</div>
        </div>

        <div class="mt-5 mb-5">
          <button class="btn btn-danger me-5" type="reset">Annuler</button>
          <button class="btn btn-success" type="submit">Valider</button>
          <!--@click.prevent="submitAnnonce"-->
        </div>
      </form>
    </div>
  </div>
  <div v-else>
    <div
      class="alert alert-success alert-dismissible fade show w-50 mt-4 d-inline-flex"
      role="alert"
    >
      <div>Vous venez de créer une annonce !</div>
      <button
        type="button"
        class="btn-close"
        data-bs-dismiss="alert"
        aria-label="Close"
      ></button>
    </div>
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Rappel des informations</h4>
        <p class="mt-4 card-text fw-normal">
          <b>Titre de l'annonce :</b> {{ data[0].titre }}
        </p>
        <p class="mt-4 card-text fw-normal">
          <b>Description de l'annonce :</b> {{ data[0].description }}
        </p>
        <p class="mt-4 card-text fw-normal">
          <b>Adresse :</b> {{ data[0].adresse.numero }}
          {{ data[0].adresse.rue }} {{ data[0].adresse.codePostal }}
          {{ data[0].adresse.ville }}
        </p>
        <p class="mt-4 card-text fw-normal">
          <b>Plante :</b> {{ selectedPlant.nom }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from 'sweetalert';

import CameraComponent from "../components/CameraComponent.vue";

export default {
  name: "CreerAnnonce",
  components: {
    CameraComponent,
  },
  data() {
    return {
      annonce: {
        titre: null,
        description: null,
        adresse: {
          numero: null,
          rue: null,
          codePostal: null,
          ville: null,
        },
      },
      plantes: [],
      selectedPlant: null,
      data: [],
    };
  },
  created() {
    this.fetchPlantes();
  },
  methods: {
    checkCP(){
      var Reg = new RegExp(/^(([0-8][0-9])|(9[0-5]))[0-9]{3}$/);
      if(!Reg.test(document.getElementById('cp').value))
        swal("Erreur de syntaxe !", "Votre code postal ne comporte pas 5 chiffres", "error");
    },
    async submitAnnonce() {
      try {
        const response = await axios.post(
          "http://localhost:8080/annonces",
          this.annonce,
          {
            auth: {
              username: "admin",
              password: "password",
            },
          }
        );
        if (this.selectedPlant !== null) {
          await axios.put(
            response.data._links.self.href + "/plantes",
            this.selectedPlant._links.self.href,
            {
              headers: {
                "Content-Type": "text/uri-list",
              },
              auth: {
                username: "admin",
                password: "password",
              },
            }
          );
        }
        this.data.push(response.data);
      } catch (error) {
        swal("Veuillez nous excuser...", "Une erreur est survenue de notre côté", "error");
        console.error(error);
      }
    },
    async fetchPlantes() {
      try {
        const response = await axios.get("http://localhost:8080/plantes", {
          auth: {
            username: "admin",
            password: "password",
          },
        });
        if (
          response.data._embedded.plantes !== null ||
          !response.data._embedded.plantes.length
        ) {
          this.plantes = response.data._embedded.plantes;
        }
      } catch (error) {
        swal("Veuillez nous excuser...", "Une erreur est survenue de notre côté", "error");
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
.card {
  border-color: var(--color-background);
  background-color: var(--color-background);
}

.input-group-text {
  color: var(--color-secondary);
}

@media (max-width: 991.98px) {
  #numero {
    flex: 0 0 auto;
    width: 42%;
  }
  #voie {
    flex: 0 0 auto;
    width: 83.33333333%;
  }
  #cp {
    flex: 0 0 auto;
    width: 42%;
  }
  #ville {
    flex: 0 0 auto;
    width: 75%;
  }
}
</style>
