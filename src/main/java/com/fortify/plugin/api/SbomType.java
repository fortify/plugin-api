/*
 * Copyright 2023 Open Text
 */

package com.fortify.plugin.api;

public enum SbomType {
    CYCLONEDX_JSON(SbomFormat.CYCLONEDX, SbomSerialization.JSON),
    CYCLONEDX_XML(SbomFormat.CYCLONEDX, SbomSerialization.XML),
    SPDX_RDFXML(SbomFormat.SPDX, SbomSerialization.RDF_XML),
    SPDX_JSON(SbomFormat.SPDX, SbomSerialization.JSON),
    SPDX_XLSX(SbomFormat.SPDX, SbomSerialization.XLSX),
    SPDX_XML(SbomFormat.SPDX, SbomSerialization.XML),
    SPDX_YAML(SbomFormat.SPDX, SbomSerialization.YAML),
    SWID_XML(SbomFormat.SWID, SbomSerialization.XML);

    private SbomFormat format;
    private SbomSerialization serialization;
    SbomType(SbomFormat format, SbomSerialization serialization) {
        this.format = format;
        this.serialization = serialization;
    }

    public SbomFormat getFormat() { return format; }
    public SbomSerialization getSerialization() { return serialization; }
}
