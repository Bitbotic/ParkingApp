package com.madrid.parking.android.model;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.kobjects.isodate.IsoDate;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/**
 * @author Vladimir
 *         Used to marshal Dates - crucial to serialization for SOAP
 */
public class MarshalDate implements Marshal {

    public Object readInstance(XmlPullParser parser, String namespace, String name,
                               PropertyInfo expected) throws IOException, XmlPullParserException {

        return IsoDate.stringToDate(parser.nextText(), IsoDate.DATE_TIME);
    }

    public void register(SoapSerializationEnvelope cm) {
        cm.addMapping(cm.xsd, "DateTime", Date.class, this);
    }

    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {

        String a = IsoDate.dateToString((Date) obj, IsoDate.DATE_TIME);

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        String lFormatTemplate = "yyyy-MM-dd'T'hh:mm:ss";
        DateFormat lDateFormat = new SimpleDateFormat(lFormatTemplate);
        String lDate = lDateFormat.format(currentLocalTime);

        //writer.startTag("http://schemas.datacontract.org/2004/07/InfoParking", "date");

        writer.text(lDate);

        //writer.endTag("http://schemas.datacontract.org/2004/07/InfoParking", "date");
    }

}