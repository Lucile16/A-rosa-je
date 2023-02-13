<template>
  <h1>Création d'une annonce</h1>
  <div v-if="!data.length">
    <div class="d-flex flex-column align-items-center">
      <!-- Trouver comment revenir sur cette page sans avoir à réactualiser la page quand on a soumis le formulaire -->
      <form class="row g-3 justify-content-center container text-center mt-2" v-on:submit.prevent="submitAnnonce"
        action="http://localhost:8081/#/creer" method="POST">
        <div class="col-md-10">
          <div class="input-group has-validation">
            <span class="input-group-text">Nom de l'annonce</span>
            <input type="text" class="form-control" v-model="annonce.titre" maxlength="90" required />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <!-- <div class="col-md-10">
          <input class="form-control" type="file" id="formFile" />
        </div>

        <div class="col-md-10">
          <label>Prendre une photo :</label>
          <CameraComponent
            class="border-primary p-2 w-100"
            :items="annonce.items"
          ></CameraComponent>
        </div> -->

        <div class="mt-5 col-md-10">
          <div class="has-validation">
            <span class="input-group-text">Description</span>
            <textarea class="form-control" v-model="annonce.description" rows="8" required></textarea>
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3">
          <div class="input-group has-validation">
            <span class="input-group-text">Numéro de rue</span>
            <input type="number" class="form-control" v-model="annonce.adresse.numero" required />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7">
          <div class="input-group has-validation">
            <span class="input-group-text">Rue/Voie</span>
            <input type="text" class="form-control" v-model="annonce.adresse.rue" maxlength="90" required />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-3">
          <div class="input-group has-validation">
            <span class="input-group-text">Code postal</span>
            <input type="number" class="form-control" v-model="annonce.adresse.codePostal" required />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-7">
          <div class="input-group has-validation">
            <span class="input-group-text">Ville</span>
            <input type="text" class="form-control" v-model="annonce.adresse.ville" maxlength="90" required />
            <div class="invalid-feedback">Veuillez remplir ce champs</div>
          </div>
        </div>

        <div class="mt-5 col-md-5">
          <span class="input-group-text">Plante</span>
          <select class="form-select" v-model="selectedPlant" required>
            <option selected disabled value="">Choisissez une plante...</option>
            <option v-for="plante in plantes" :key="plante.id" :value="plante">
              {{ plante.nom }}
            </option>
          </select>
          <div class="invalid-feedback">Veuillez sélectionner une plante</div>
        </div>

        <div class="mt-5 mb-5">
          <button class="btn btn-success me-5" type="submit">Valider</button>
          <!--@click.prevent="submitAnnonce"-->
          <button class="btn btn-danger" type="reset">Annuler</button>
        </div>
      </form>
    </div>
  </div>
  <div v-else>
    <div class="alert alert-success alert-dismissible fade show w-50 mt-4 d-inline-flex" role="alert">
      <div>Vous venez de créer une annonce !</div>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Rappel des informations</h4>
        <p class="mt-4 card-text fw-normal">
          <b>Titre de l'annonce :</b> {{ annonce.titre }}
        </p>
        <p class="mt-4 card-text fw-normal">
          <b>Description de l'annonce :</b> {{ annonce.description }}
        </p>
        <p class="mt-4 card-text fw-normal">
          <b>Adresse :</b> {{ annonce.adresse.numero }}
          {{ annonce.adresse.rue }} {{ annonce.adresse.codePostal }}
          {{ annonce.adresse.ville }}
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
export default {
  name: "CreerAnnonce",
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
    async submitAnnonce() {
      try {
        const response = await axios.post(
          "http://localhost:8080/annonces",
          this.annonce, {
          auth: {
            username: 'admin',
            password: 'password'
          }
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
                username: 'admin',
                password: 'password'
              }
            }
          );
        }
        this.data.push(response.data);
      } catch (error) {
        console.error(error);
      }
    },
    async fetchPlantes() {
      try {
        const response = await axios.get("http://localhost:8080/plantes", {
          auth: {
            username: 'admin',
            password: 'password'
          }
        });
        if (
          response.data._embedded.plantes !== null ||
          !response.data._embedded.plantes.length
        ) {
          this.plantes = response.data._embedded.plantes;
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style>
.card {
  border-color: var(--color-background);
  background-color: var(--color-background);
}

.input-group-text {
  color: var(--color-secondary);
}
</style>
