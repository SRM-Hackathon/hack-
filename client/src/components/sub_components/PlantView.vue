<template>
    <v-layout row justify-center>
        <v-dialog v-model="displayModal" fullscreen transition="dialog-bottom-transition" :overlay=false>
            <v-card>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn flat icon @click="closeInfoModal" class="red--text">
                        <v-icon>fa-times</v-icon>
                    </v-btn>
                </v-card-actions>
                <v-card-title>
                    <v-container v-if="item.botanical_name !== undefined">
                        <div class="display-1">
                            {{ item.botanical_name }}
                        </div>
                        <img :src="/static/TestImage.jpg" :alt="item.title" class="image-view" />
                    </v-container>
                </v-card-title>
                <v-card-title>
                    <v-layout row wrap>
                        <v-flex xs12 md6>
                            <v-container>
                                <v-layout row wrap>
                                    <v-flex xs12>

                                    </v-flex>
                                </v-layout>
                            </v-container>
                        </v-flex>
                        <v-flex xs12 md6>
                            <gmap-map :center="{lat: 20.5937, lng: 78.9629}" :zoom="4" class="map-styles">
                                <gmap-marker v-for="pos in item.map_info" :key="pos.latitude" :position="{lat: pos.latitude, lng:pos.longitude}"></gmap-marker>
                            </gmap-map>
                        </v-flex>
                    </v-layout>
                </v-card-title>
            </v-card>
        </v-dialog>
    </v-layout>
</template>

<script>
    export default {
        props: {
            item: {
                type: Object,
                required: true
            },
            closeModal: {
                type: Function,
                required: true
            },
            showModal: {
                type: Boolean,
                required: true
            }
        },
        data() {
            return {
                displyModal: false
            };
        },
        watch: {
            showModal(updatedValue) {
                this.displayModal = updatedValue;
            }
        },
        methods: {
            closeInfoModal() {
                this.displayModal = false;
                this.closeModal();
            }
        }
    }

</script>
