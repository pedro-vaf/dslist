package com.devsuperior.dslist.projections;

public interface GameMinProjection {

    /* É necessário gerar o Get para cada dado que a consulta SQL está retornando */
    /* A consulta está no repositório - sempre respeitar o camelcase*/
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
