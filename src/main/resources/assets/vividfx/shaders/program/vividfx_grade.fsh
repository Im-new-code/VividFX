#version 150

uniform sampler2D DiffuseSampler;
uniform float Contrast;
uniform float Saturation;
uniform float Brightness;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec3 c = texture(DiffuseSampler, texCoord).rgb;
    c *= Brightness;
    c = (c - 0.5) * Contrast + 0.5;
    float luma = dot(c, vec3(0.2126, 0.7152, 0.0722));
    c = mix(vec3(luma), c, Saturation);
    c = clamp(c, 0.0, 1.0);
    fragColor = vec4(c, 1.0);
}
