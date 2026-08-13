#version 150

uniform sampler2D DiffuseSampler;
uniform float Threshold;
uniform float Gain;

in vec2 texCoord;
in vec2 oneTexel;
out vec4 fragColor;

void main() {
    vec4 c = texture(DiffuseSampler, texCoord);
    float luma = dot(c.rgb, vec3(0.2126, 0.7152, 0.0722));
    float mask = smoothstep(Threshold - 0.12, Threshold + 0.12, luma);
    vec3 bright = max(c.rgb - vec3(Threshold), vec3(0.0)) * Gain;
    bright *= mask;
    fragColor = vec4(bright, 1.0);
}
