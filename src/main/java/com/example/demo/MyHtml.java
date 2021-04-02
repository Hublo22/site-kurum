package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.dom.Element;
import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyHtml extends Component {

    private static final PropertyDescriptor<String, String> innerHtmlDescriptor = PropertyDescriptors
            .propertyWithDefault("innerHTML", "");

    /**
     * Creates an instance based on the HTML fragment read from the stream. The
     * fragment must have exactly one root element.
     * <p>
     * A best effort is done to parse broken HTML but no guarantees are given
     * for how invalid HTML is handled.
     * <p>
     * Any heading or trailing whitespace is removed while parsing but any
     * whitespace inside the root tag is preserved.
     *
     * @param stream
     *            the input stream which provides the HTML in UTF-8
     * @throws UncheckedIOException
     *             if reading the stream fails
     */
    public MyHtml(InputStream stream) {
        super(null);
        if (stream == null) {
            throw new IllegalArgumentException("HTML stream cannot be null");
        }
        try {
            /*
             * Cannot use any of the methods that accept a stream since they all
             * parse as a document rather than as a body fragment. The logic for
             * reading a stream into a String is the same that is used
             * internally by JSoup if you strip away all the logic to guess an
             * encoding in case one isn't defined.
             */
            setOuterHtml(UTF_8.decode(DataUtil.readToByteBuffer(stream, 0))
                    .toString());
        } catch (IOException e) {
            throw new UncheckedIOException("Unable to read HTML from stream",
                    e);
        }
    }

    /**
     * Creates an instance based on the given HTML fragment. The fragment must
     * have exactly one root element.
     * <p>
     * A best effort is done to parse broken HTML but no guarantees are given
     * for how invalid HTML is handled.
     * <p>
     * Any heading or trailing whitespace is removed while parsing but any
     * whitespace inside the root tag is preserved.
     *
     * @param outerHtml
     *            the HTML to wrap
     */
    public MyHtml(String outerHtml) {
        super(null);
        if (outerHtml == null || outerHtml.isEmpty()) {
            throw new IllegalArgumentException("HTML cannot be null or empty");
        }

        setOuterHtml(outerHtml);
    }

    public void setOuterHtml(String outerHtml) {
        Document doc = Jsoup.parseBodyFragment(outerHtml);
        int nrChildren = doc.body().children().size();
        if (nrChildren != 1) {
            String message = "HTML must contain exactly one top level element (ignoring text nodes). Found "
                    + nrChildren;
            if (nrChildren > 1) {
                String tagNames = doc.body().children().stream()
                        .map(org.jsoup.nodes.Element::tagName)
                        .collect(Collectors.joining(", "));
                message += " elements with the tag names " + tagNames;
            }
            throw new IllegalArgumentException(message);
        }

        org.jsoup.nodes.Element root = doc.body().child(0);
        Attributes attrs = root.attributes();

        Component.setElement(this, new Element(root.tagName()));
        attrs.forEach(this::setAttribute);

        doc.outputSettings().prettyPrint(false);
        setInnerHtml(root.html());

    }

    private void setAttribute(Attribute attribute) {
        String name = attribute.getKey();
        String value = attribute.getValue();
        if (value == null) {
            value = "";
        }
        getElement().setAttribute(name, value);
    }

    /**
     * Sets the inner HTML, i.e. everything inside the root element.
     *
     * @param innerHtml
     *            the inner HTML, not <code>null</code>
     */
    private void setInnerHtml(String innerHtml) {
        set(innerHtmlDescriptor, innerHtml);
    }

    /**
     * Gets the inner HTML, i.e. everything inside the root element.
     *
     * @return the inner HTML, not <code>null</code>
     */
    public String getInnerHtml() {
        return get(innerHtmlDescriptor);
    }
}
