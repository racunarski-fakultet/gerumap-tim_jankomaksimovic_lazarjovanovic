package gui.swing.state;

import gui.swing.stateController.StateSettings;

public class ManagerState {

        private ComponentState componentState;

        //private DeleteState deleteState;
        private MoveState moveState;
        private ConnectState connectState;
        private SelectState selectState;

        private StateSettings stateSettings;

        private State state;

        public ManagerState() {
            initialise();
        }

        private void initialise(){
            //deleteState = new DeleteState();
            componentState = new ComponentState();
            moveState = new MoveState();
            connectState = new ConnectState();
            selectState = new SelectState();

            state = componentState;
        }



        //public void setDeleteState() {
            //this.state = deleteState;
       // }


        public void setComponentState() {
            this.state = componentState;
        }


        public void setMoveState() {
            this.state = moveState;
        }


        public void setConnectState() {
            this.state = connectState;
        }


        public void setSelectState() {
            this.state = selectState;
        }


        public State getState() {
            return state;
        }

        /*public void setState(State state) {
            this.state = state;
        }*/

    }


